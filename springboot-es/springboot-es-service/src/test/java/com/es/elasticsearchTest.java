package com.es;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import com.es.api.VehicleService;
import com.es.api.VehicleTemplateService;
import com.es.dto.AddressPointDto;
import com.es.dto.VehicleDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticSearchApplication.class)
public class elasticsearchTest {
	
	@Autowired
    private VehicleService vehicleService;
	@Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
	@Autowired
    private VehicleTemplateService vehicleTemplateService;
	
	
	@Test
    public void queryGeos(){
		double lat = 39.929986;
        double lon = 116.395645;
        List<VehicleDto> list = vehicleTemplateService.queryForList(lat, lon);
        System.out.println(list);
	}
	
	@Test
    public void bulkIndex(){
		List<VehicleDto> list = new ArrayList<>();
    	double lat = 39.929986;
        double lon = 116.395645;
    	List<AddressPointDto> addressPointDto = new ArrayList<>();
        for (int i = 1 ; i < 10; i++) {
            double max = 0.00001;
            double min = 0.000001;
            Random random = new Random();
            double s = random.nextDouble() % (max - min + 1) + max;
            DecimalFormat df = new DecimalFormat("######0.000000");
            // System.out.println(s);
            String lons = df.format(s + lon);
            String lats = df.format(s + lat);
            Double dlon = Double.valueOf(lons);
            Double dlat = Double.valueOf(lats);
 
            AddressPointDto person = new AddressPointDto();
            person.setId(Long.valueOf(i));
            person.setName("李四" + i);
            person.setType("类型" + i);
            person.setXjTime(new Date());
            if(i%2 == 0) {
            	person.setRemark("我爱中国，我爱祖国"+i);
            }
            if(i%3 == 0) {
            	person.setRemark("我不爱美国，我爱祖国"+i);
            }else{
            	person.setRemark("我不爱日本，我爱祖国"+i);
            }
            
            person.setAddress(new GeoPoint(dlat,dlon));
            addressPointDto.add(person);
        }
    	for (int j = 0; j < 10; j++) {
    		VehicleDto vehicleDto = new VehicleDto();
    		vehicleDto.setId(Long.valueOf(j));
        	vehicleDto.setCarDriver("李四"+j);
        	vehicleDto.setCarName(j+".2米");
        	vehicleDto.setCarType(j+"");
        	vehicleDto.setPrice(j*1000);
        	vehicleDto.setStatus("1");
        	vehicleDto.setAddressPointDto(addressPointDto);
        	list.add(vehicleDto);
		}
    	
    	System.out.println("list:"+list);
		vehicleTemplateService.bulkIndex(list);
	}
	
	@Test
    public void queryDto(){
//		 Pageable pageable = new PageRequest(0, 5);
//		 NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("carDriver", "张三1"));
		 NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("addressPointDto.name", "张三1")).withPageable(PageRequest.of(0,5));
	     SearchQuery searchQuery = builder.build();
	 
        //queryForList默认是分页，走的是queryForPage，默认10个
        List<VehicleDto> vehicleDto = elasticsearchTemplate.queryForList(searchQuery, VehicleDto.class);
		System.err.println("findAll:"+vehicleDto);
	 }
	
	
	@Test
    public void findByAddressPointDtoName(){
		String name = "张三1";
		List<VehicleDto> list = vehicleService.findByAddressPointDtoName(name,PageRequest.of(0,5));
		System.err.println("findAll:"+list);
	 }
	
	@Test
    public void findByCarDriverAndPrice(){
		String carDriver = "张三1";
		int price = 1000;
//		Pageable pageable = new PageRequest(0, 5);
		List<VehicleDto> list = vehicleService.findByCarDriverAndPrice(carDriver, price, PageRequest.of(0,5));
		System.err.println("findAll:"+list);
	 }
	
	@Test
    public void findAll(){
		 List<VehicleDto> list = vehicleService.findAll();
		 System.err.println("findAll:"+list);
	 }
	
	@Test
    public void del(){
		Long id = 18L;
		vehicleService.del(id);
	}
	
	/**
     * 创建Index
     */
    @Test
    public void createIndex(){
    	List<VehicleDto> list = new ArrayList<>();
    	double lat = 39.929986;
        double lon = 116.395645;
    	List<AddressPointDto> addressPointDto = new ArrayList<>();
        for (int i = 1 ; i < 10; i++) {
            double max = 0.00001;
            double min = 0.000001;
            Random random = new Random();
            double s = random.nextDouble() % (max - min + 1) + max;
            DecimalFormat df = new DecimalFormat("######0.000000");
            // System.out.println(s);
            String lons = df.format(s + lon);
            String lats = df.format(s + lat);
            Double dlon = Double.valueOf(lons);
            Double dlat = Double.valueOf(lats);
 
            AddressPointDto person = new AddressPointDto();
            person.setId(Long.valueOf(i));
            person.setName("张三" + i);
            person.setType("类型" + i);
            person.setXjTime(new Date());
            if(i%2 == 0) {
            	person.setRemark("我爱中国，我爱祖国"+i);
            }
            if(i%3 == 0) {
            	person.setRemark("我不爱美国，我爱祖国"+i);
            }else{
            	person.setRemark("我不爱日本，我爱祖国"+i);
            }
            
            person.setAddress(new GeoPoint(dlat,dlon));
            addressPointDto.add(person);
        }
    	for (int j = 30; j < 40; j++) {
    		VehicleDto vehicleDto = new VehicleDto();
    		vehicleDto.setId(Long.valueOf(j));
        	vehicleDto.setCarDriver("赵六"+j);
        	vehicleDto.setCarName(j+".2米");
        	vehicleDto.setCarType(j+"");
        	vehicleDto.setPrice(j*1000);
        	vehicleDto.setStatus("1");
        	vehicleDto.setAddressPointDto(addressPointDto);
        	list.add(vehicleDto);
		}
    	
//    	vehicleService.set(vehicleDto);
    	System.out.println("list:"+list);
    	//如果需要使用到geo必须用ElasticsearchTemplate的方式添加
    	vehicleService.setAll(list);
    }
}
