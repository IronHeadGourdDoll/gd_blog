import Vue from 'vue'
import Router from 'vue-router'
import Header from "../components/Header";
import Footer from "../components/Footer";
import Home from "../pages/Home";
import Index from "../pages/Index";
import ArticleDetail from "../pages/ArticleDetail";
import ArticleEdit from "../pages/ArticleEdit";
import Message from "../pages/Message";
import Pigeonhole from "../pages/Pigeonhole";
import Login from "../pages/Login";
import Register from "../pages/Register";
import About from "../pages/About";
import ArticleList from "../pages/ArticleList";
import VueRouter from "vue-router";

Vue.use(Router)

// 解决ElementUI导航栏中的vue-router在3.0版本以上重复点菜单报错问题
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

//路由注册
export default new Router({
  mode: 'history',//链接显示# 取消
  routes: [//查询用户名默认zhangsan
    //index
    {
      path:'/',
      name:'home',
      component:Home,
      redirect:'/index',
      children:[
        {
          path: '/index',
          name: 'index',
          component: Index,
        },
        //article
        {
          path: '/article/category/:categoryId', component: ArticleList,//:/传递参数
          children:[
            {path:'edit/',component:ArticleEdit}, //文章编辑路由
            {path:'detail/',component:ArticleDetail}, //文章详情路由
          ]
        },
        //pigeonhole
        {path: '/pigeonhole', component: Pigeonhole},
        //message
        {path: '/message', component: Message},
        //about
        {path: '/about', component: About},
      ]
    },
    //login
    {path: '/login', component: Login},
    //register
    {path: '/register', component: Register},
  ]
})
