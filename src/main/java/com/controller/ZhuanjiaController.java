
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 专家
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhuanjia")
public class ZhuanjiaController {
    private static final Logger logger = LoggerFactory.getLogger(ZhuanjiaController.class);

    private static final String TABLE_NAME = "zhuanjia";

    @Autowired
    private ZhuanjiaService zhuanjiaService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CaozuorizhiService caozuorizhiService;//操作日志
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private NewsService newsService;//资讯信息
    @Autowired
    private XiangmuService xiangmuService;//项目
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("专家".equals(role))
            params.put("zhuanjiaId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = zhuanjiaService.queryPage(params);

        //字典表数据转换
        List<ZhuanjiaView> list =(List<ZhuanjiaView>)page.getList();
        for(ZhuanjiaView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"列表查询",list.toString());
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhuanjiaEntity zhuanjia = zhuanjiaService.selectById(id);
        if(zhuanjia !=null){
            //entity转view
            ZhuanjiaView view = new ZhuanjiaView();
            BeanUtils.copyProperties( zhuanjia , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
    caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"单条数据查看",view.toString());
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuanjiaEntity zhuanjia, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhuanjia:{}",this.getClass().getName(),zhuanjia.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhuanjiaEntity> queryWrapper = new EntityWrapper<ZhuanjiaEntity>()
            .eq("username", zhuanjia.getUsername())
            .or()
            .eq("zhuanjia_phone", zhuanjia.getZhuanjiaPhone())
            .or()
            .eq("zhuanjia_id_number", zhuanjia.getZhuanjiaIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuanjiaEntity zhuanjiaEntity = zhuanjiaService.selectOne(queryWrapper);
        if(zhuanjiaEntity==null){
            zhuanjia.setCreateTime(new Date());
            zhuanjia.setPassword("123456");
            zhuanjiaService.insert(zhuanjia);
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"新增",zhuanjia.toString());
            return R.ok();
        }else {
            return R.error(511,"账户或者专家手机号或者专家身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhuanjiaEntity zhuanjia, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhuanjia:{}",this.getClass().getName(),zhuanjia.toString());
        ZhuanjiaEntity oldZhuanjiaEntity = zhuanjiaService.selectById(zhuanjia.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zhuanjia.getZhuanjiaPhoto()) || "null".equals(zhuanjia.getZhuanjiaPhoto())){
                zhuanjia.setZhuanjiaPhoto(null);
        }

            zhuanjiaService.updateById(zhuanjia);//根据id更新
            List<String> strings = caozuorizhiService.clazzDiff(zhuanjia, oldZhuanjiaEntity, request,new String[]{"updateTime"});
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"修改",strings.toString());
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhuanjiaEntity> oldZhuanjiaList =zhuanjiaService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zhuanjiaService.deleteBatchIds(Arrays.asList(ids));

        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"删除",oldZhuanjiaList.toString());
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ZhuanjiaEntity> zhuanjiaList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZhuanjiaEntity zhuanjiaEntity = new ZhuanjiaEntity();
//                            zhuanjiaEntity.setUsername(data.get(0));                    //账户 要改的
//                            zhuanjiaEntity.setPassword("123456");//密码
//                            zhuanjiaEntity.setZhuanjiaName(data.get(0));                    //专家姓名 要改的
//                            zhuanjiaEntity.setZhuanjiaPhone(data.get(0));                    //专家手机号 要改的
//                            zhuanjiaEntity.setZhuanjiaIdNumber(data.get(0));                    //专家身份证号 要改的
//                            zhuanjiaEntity.setZhuanjiaPhoto("");//详情和图片
//                            zhuanjiaEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            zhuanjiaEntity.setZhuanjiaEmail(data.get(0));                    //专家邮箱 要改的
//                            zhuanjiaEntity.setJinyongTypes(Integer.valueOf(data.get(0)));   //账户状态 要改的
//                            zhuanjiaEntity.setCreateTime(date);//时间
                            zhuanjiaList.add(zhuanjiaEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //专家手机号
                                if(seachFields.containsKey("zhuanjiaPhone")){
                                    List<String> zhuanjiaPhone = seachFields.get("zhuanjiaPhone");
                                    zhuanjiaPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> zhuanjiaPhone = new ArrayList<>();
                                    zhuanjiaPhone.add(data.get(0));//要改的
                                    seachFields.put("zhuanjiaPhone",zhuanjiaPhone);
                                }
                                //专家身份证号
                                if(seachFields.containsKey("zhuanjiaIdNumber")){
                                    List<String> zhuanjiaIdNumber = seachFields.get("zhuanjiaIdNumber");
                                    zhuanjiaIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhuanjiaIdNumber = new ArrayList<>();
                                    zhuanjiaIdNumber.add(data.get(0));//要改的
                                    seachFields.put("zhuanjiaIdNumber",zhuanjiaIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ZhuanjiaEntity> zhuanjiaEntities_username = zhuanjiaService.selectList(new EntityWrapper<ZhuanjiaEntity>().in("username", seachFields.get("username")));
                        if(zhuanjiaEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhuanjiaEntity s:zhuanjiaEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //专家手机号
                        List<ZhuanjiaEntity> zhuanjiaEntities_zhuanjiaPhone = zhuanjiaService.selectList(new EntityWrapper<ZhuanjiaEntity>().in("zhuanjia_phone", seachFields.get("zhuanjiaPhone")));
                        if(zhuanjiaEntities_zhuanjiaPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhuanjiaEntity s:zhuanjiaEntities_zhuanjiaPhone){
                                repeatFields.add(s.getZhuanjiaPhone());
                            }
                            return R.error(511,"数据库的该表中的 [专家手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //专家身份证号
                        List<ZhuanjiaEntity> zhuanjiaEntities_zhuanjiaIdNumber = zhuanjiaService.selectList(new EntityWrapper<ZhuanjiaEntity>().in("zhuanjia_id_number", seachFields.get("zhuanjiaIdNumber")));
                        if(zhuanjiaEntities_zhuanjiaIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhuanjiaEntity s:zhuanjiaEntities_zhuanjiaIdNumber){
                                repeatFields.add(s.getZhuanjiaIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [专家身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhuanjiaService.insertBatch(zhuanjiaList);
                        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"批量新增",zhuanjiaList.toString());
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ZhuanjiaEntity zhuanjia = zhuanjiaService.selectOne(new EntityWrapper<ZhuanjiaEntity>().eq("username", username));
        if(zhuanjia==null || !zhuanjia.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(zhuanjia.getJinyongTypes() != 1)
            return R.error("账户已被禁用");
        String token = tokenService.generateToken(zhuanjia.getId(),username, "zhuanjia", "专家");
        R r = R.ok();
        r.put("token", token);
        r.put("role","专家");
        r.put("username",zhuanjia.getZhuanjiaName());
        r.put("tableName","zhuanjia");
        r.put("userId",zhuanjia.getId());
        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"登录",zhuanjia.toString());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ZhuanjiaEntity zhuanjia, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ZhuanjiaEntity> queryWrapper = new EntityWrapper<ZhuanjiaEntity>()
            .eq("username", zhuanjia.getUsername())
            .or()
            .eq("zhuanjia_phone", zhuanjia.getZhuanjiaPhone())
            .or()
            .eq("zhuanjia_id_number", zhuanjia.getZhuanjiaIdNumber())
            ;
        ZhuanjiaEntity zhuanjiaEntity = zhuanjiaService.selectOne(queryWrapper);
        if(zhuanjiaEntity != null)
            return R.error("账户或者专家手机号或者专家身份证号已经被使用");
        zhuanjia.setJinyongTypes(1);//启用
        zhuanjia.setCreateTime(new Date());
        zhuanjiaService.insert(zhuanjia);

        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"注册",zhuanjia.toString());
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        ZhuanjiaEntity zhuanjia = zhuanjiaService.selectById(id);
        zhuanjia.setPassword("123456");
        zhuanjiaService.updateById(zhuanjia);
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"重置密码",zhuanjia.toString());
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        ZhuanjiaEntity zhuanjia = zhuanjiaService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(zhuanjia.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(zhuanjia.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        zhuanjia.setPassword(newPassword);
		zhuanjiaService.updateById(zhuanjia);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ZhuanjiaEntity zhuanjia = zhuanjiaService.selectOne(new EntityWrapper<ZhuanjiaEntity>().eq("username", username));
        if(zhuanjia!=null){
            zhuanjia.setPassword("123456");
            zhuanjiaService.updateById(zhuanjia);
            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"忘记密码",zhuanjia.toString());
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrZhuanjia(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ZhuanjiaEntity zhuanjia = zhuanjiaService.selectById(id);
        if(zhuanjia !=null){
            //entity转view
            ZhuanjiaView view = new ZhuanjiaView();
            BeanUtils.copyProperties( zhuanjia , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zhuanjiaService.queryPage(params);

        //字典表数据转换
        List<ZhuanjiaView> list =(List<ZhuanjiaView>)page.getList();
        for(ZhuanjiaView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"列表查询",list.toString());
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhuanjiaEntity zhuanjia = zhuanjiaService.selectById(id);
            if(zhuanjia !=null){


                //entity转view
                ZhuanjiaView view = new ZhuanjiaView();
                BeanUtils.copyProperties( zhuanjia , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                    caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"单条数据查看",view.toString());
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZhuanjiaEntity zhuanjia, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhuanjia:{}",this.getClass().getName(),zhuanjia.toString());
        Wrapper<ZhuanjiaEntity> queryWrapper = new EntityWrapper<ZhuanjiaEntity>()
            .eq("username", zhuanjia.getUsername())
            .or()
            .eq("zhuanjia_phone", zhuanjia.getZhuanjiaPhone())
            .or()
            .eq("zhuanjia_id_number", zhuanjia.getZhuanjiaIdNumber())
//            .notIn("zhuanjia_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuanjiaEntity zhuanjiaEntity = zhuanjiaService.selectOne(queryWrapper);
        if(zhuanjiaEntity==null){
            zhuanjia.setCreateTime(new Date());
            zhuanjia.setPassword("123456");
        zhuanjiaService.insert(zhuanjia);

            caozuorizhiService.insertCaozuorizhi(String.valueOf(request.getSession().getAttribute("role")),TABLE_NAME,String.valueOf(request.getSession().getAttribute("username")),"前台新增",zhuanjia.toString());
            return R.ok();
        }else {
            return R.error(511,"账户或者专家手机号或者专家身份证号已经被使用");
        }
    }

}

