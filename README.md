# audit
工程跟踪审计管理系统开发
### 项目框架
- 框架框架
  1. 项目基于springboot
  2. 持久层框架目前使用mybatis
  3. 数据库统一使用mysql5.7
  4. 项目安全框架使用shiro
### 模块任务说明
- 任务要求
  1. 用户注册登录模块  
  系统管理员Administrator进行注册操作注册新用户，随后分配用户所属角色。每个用户通过指定的用户名密码进行登录，系统校验判断是否登录成功。
  2. 用户角色管理模块  
  系统管理员Administrator分配每个用户所属部门和所属的角色，每种角色拥有不同的权限来进行项目每个模块的不同业务。每种权限对应着每个业务的子功能的权限code。上述一对多对多的关系来作为整个项目的核心业务管理体系。
  系统管理员Administrator对部门、用户、角色、权限进行增删改查的操作。
  3. 工程实施（立项、预算、拨付、结算）并审批模块  
  由立项部门的用户来进行工程立项，随后审核部门的指定用户来对申请进行审批。  
  在立项审批通后，系统后台通过立项报表的参数进行资金预算，生成资金报表，随后由审核部门的指定用户对数据进行审核。  
  在工程预算审批通过后，资金管理部门拨付工程资金，随后由审核部门的指定用户确认资金数目并审核。  
  工程结束后由发起工程的部门统计工程实际使用资金，并提供数据，再审核部门管理审批通过后，资金管理部门对资金进行最后的多退少补。 
  4. 工程跟踪模块  
  督察部门负责跟踪整个项目的实施情况，这个业务贯穿工程的施工进度，按每隔一月的进度来进行总体督察，若工程未达到预期比例则向施工单位发出警告通知。  
  5. 生成报表以及用户日志管理模块  
  在工程结算结束后，局领导可以查看资金报表。  
  用户日志模块主要为对系统用户操作跟踪。
### 权限认证使用方式方式
- 权限认证
  1. 通过shiro进行每个接口的权限认证
  2. 大致方式为登录获取token，通过token放入请求头，例如key为authToken，value为8a754c58-7351-4cf0-a41d-fd6a7fd9320d得到user用户的信息
  3. 得到用户的信息，随后通过用户获取角色，随后通过角色获取权限code
  4. 通过接口上的注解，例如@RequiresPermissions("user:test")得到所需要的code，如果用户没有此code，则无法正常使用这个接口
  5. 详细写法请看shiroCofig配置
### 已完成模块
- 注册登录模块
  1. 由系统管理员Administrator进行注册用户，通过发送给用户的邮箱的验证码来校验
  2. 密码加密统一采用加盐后的MD5加密
- 列表分页模块
  1. 采用pageHelper插件来进行分页操作
- 日志模块
  1. 日志配置开发日志
- 工程实施模块
  1. 在utils包中加入Identification数据标识类对以后业务流程实现是一些参数标识起一定作用
  2. 工程阶段变更，加入工程立项到结束的十个工程阶段（1-立项 2-立项审核中 3-预算 4-预算审核中 5-拨付 6-拨付审核中 7-结算 8-结算审核中 9-实施中 10-实施结束）
  3. 工程具体设施查询列表
  4. 工程立项到结束的所有过程
- 目录模块
  1. 查询目录，生成json
  2. 完成动态目录
- 权限模块
  1. 用户分配角色
  2. 角色分配菜单
### 权限模块优化的方向
- 返回集优化
  1. 更新JsonResult类来统一返回集格式（已完成）
- 其他模块
  1. 其他模块尽快完善更新（持续中）
  2. 同前端交互完成审核界面和立项界面(已完成)
  3. 主界面优化
  4. 用户管理、角色管理、菜单管理的实现（已完成）
### 完成的优化
- 统一返回集合
  1. 使用Result来统一了后端返回集