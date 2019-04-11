package com.es.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.es.api.VehicleTemplateService;
import com.es.dto.VehicleDto;

@Service
public class VehicleTemplateServiceImpl implements VehicleTemplateService{
	
	private @Autowired ElasticsearchTemplate elasticsearchTemplate;

	public void bulkIndex(List<VehicleDto> vehicleDto) {
		int counter = 0;
        List<IndexQuery> queries = new ArrayList<>();
        //https://github.com/spring-projects/spring-data-elasticsearch/wiki/Geo-indexing-and-request
        //必须使用Mapping先去创建然后在添加数据，否则会出现geo类型错误
        elasticsearchTemplate.createIndex(VehicleDto.class);
        elasticsearchTemplate.putMapping(VehicleDto.class);
        for (VehicleDto vehiclePointEsDto : vehicleDto) {
            IndexQuery indexQuery = new IndexQuery();
            indexQuery.setId(vehiclePointEsDto.getId() + "");
                indexQuery.setObject(vehiclePointEsDto);
                //上面的那几步也可以使用IndexQueryBuilder来构建
                //IndexQuery index = new IndexQueryBuilder().withId(VehiclePointEsDto.getId() + "").withObject(VehicleDto).build();
                queries.add(indexQuery);
                if (counter % 500 == 0) {
                    elasticsearchTemplate.bulkIndex(queries);
                    queries.clear();
                    System.out.println("bulkIndex counter : " + counter);
            }
            counter++;
        }
        if (queries.size() > 0) {
            elasticsearchTemplate.bulkIndex(queries);
            System.out.println("运行完成");
        }
        System.out.println("bulkIndex completed.");
	}
	
	 /**
    *
    geo_distance: 查找距离某个中心点距离在一定范围内的位置
    geo_bounding_box: 查找某个长方形区域内的位置
    geo_distance_range: 查找距离某个中心的距离在min和max之间的位置
    geo_polygon: 查找位于多边形内的地点。
    sort可以用来排序
    */
	@Override
	public List<VehicleDto> queryForList(double lat, double lon) {
		Long nowTime = System.currentTimeMillis();
        //查询某经纬度10000米范围内
        GeoDistanceQueryBuilder builder = QueryBuilders.geoDistanceQuery("addressPointDto.address").point(lat, lon)
                .distance(10000, DistanceUnit.METERS);
       
        GeoDistanceSortBuilder sortBuilder = SortBuilders
//        		.geoDistanceSort("address")
        		.geoDistanceSort("addressPointDto.address",new GeoPoint(lat, lon))//高版本使用
        		.point(lat, lon)
                .unit(DistanceUnit.METERS)
                .order(SortOrder.ASC);
        //分页查询50条
//		Pageable pageable = new PageRequest(0, 50);
        //查询经纬度10000米范围内，并根据坐标排序
//        NativeSearchQueryBuilder builder1 = new NativeSearchQueryBuilder().withFilter(builder).withPageable(pageable).withSort(sortBuilder);
        /**
         * 使用QueryBuilder
         * termQuery("key", obj) 完全匹配(不进行分词匹配)
         * termsQuery("key", obj1, obj2..)   一次匹配多个值
         * matchQuery("key", Obj) 单个匹配(分词匹配), field不支持通配符, 前缀具高级特性
         * multiMatchQuery("text", "field1", "field2"..);  匹配多个字段, field有通配符忒行
         * matchAllQuery();         匹配所有文件
         * matchPhraseQuery() 类似于数据库里的“%名字57%”这种
         */
        //查询经纬度10000米范围内，name字段的值为名字57，并根据坐标排序
//        QueryBuilder queryBuilder = QueryBuilders.termQuery("name", "名字57");
//        NativeSearchQueryBuilder builder1 = new NativeSearchQueryBuilder().withQuery(queryBuilder).withFilter(builder).withPageable(pageable).withSort(sortBuilder);
//        NativeSearchQueryBuilder builder1 = new NativeSearchQueryBuilder().withQuery(QueryBuilders.termQuery("name", "名字57")).withFilter(builder).withPageable(pageable).withSort(sortBuilder);
		
        /**
         * 组合查询
         * must(QueryBuilders) :   AND
         * mustNot(QueryBuilders): NOT
         * should:                  : OR
         */
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("carDriver", "张三"));
        SortBuilder<?> sortBuilder1 = SortBuilders.fieldSort("addressPointDto.xjTime").order(SortOrder.DESC);//根据嵌套实体时间排序
//        FieldSortBuilder fieldSortBuilder = SortBuilders.fieldSort("addressPointDto.xjTime").order(SortOrder.DESC).setNestedPath("dealInfos").setNestedFilter(QueryBuilders.matchQuery("addressPointDto.id", "1"));//低版本使用
//        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("remark", "祖国"));
//        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("name", "名字57")).mustNot(QueryBuilders.matchQuery("id", "43")).should(QueryBuilders.matchQuery("type", "类型36"));
        NativeSearchQueryBuilder builder1 = new NativeSearchQueryBuilder().withQuery(queryBuilder).withFilter(builder)
        		.withPageable(PageRequest.of(0,50)).withSort(sortBuilder1);
        SearchQuery searchQuery = builder1.build();
 
        //queryForList默认是分页，走的是queryForPage，默认10个
        List<VehicleDto> VehiclePointEsDtoList = elasticsearchTemplate.queryForList(searchQuery, VehicleDto.class);
 
        System.out.println("耗时：" + (System.currentTimeMillis() - nowTime));
        return VehiclePointEsDtoList;
	}

	@Override
	public List<VehicleDto> queryDto() {
		 NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder().withQuery(QueryBuilders.termQuery("carDriver", "李四"));
//				 .withPageable(PageRequest.of(0,50));
	     SearchQuery searchQuery = builder.build();
	 
        //queryForList默认是分页，走的是queryForPage，默认10个
        List<VehicleDto> VehiclePointEsDtoList = elasticsearchTemplate.queryForList(searchQuery, VehicleDto.class);
        return VehiclePointEsDtoList;
	}

}
