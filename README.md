#springboot 简单脚手架
此项目是多 module 的 springboot 项目

##包含功能
###1.代码生成
###2.http请求模板方法
###3.RedisTemplate Redis请求模板方法

##代码生成

执行leaf-generator中的MysqlGenerator main 方法即可

##http请求模板方法
使用RestService类直接注入 bean 即可使用

@Autowired
private RestService restService;

##RedisTemplate Redis请求模板方法
使用RedisTemplate类即可

@Autowired
    private RedisTemplate<String, Object> redisTemplate;


