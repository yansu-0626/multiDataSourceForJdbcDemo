<h1>自己练手的项目</h1>
<h3>multiDataSourceForJdbcDemo</h3>

#### 项目介绍
  此项目是本人有单服务进行双数据源查询数据而写。使用最新的`微服务`技术，使用的后台技术主要有`jdbc`数据源，`SpringMVC`，`SpringBoot`，`Restful`。

#### 主要思路
    config类采用 '@ConfigurationProperties("spring.datasource.primary")' 注解注入数据源。又分别为每个数据源构建'JdbcTemplate'对象 交'spring'管理。
  
#### 使用方式
    在要使用的类中直接
    @Autowired
    private JdbcTemplate secondaryJdbcTemplate;'
    注入,注意名称。或可用'@Qualify'注入也可。

