<template>
    <div>
      <el-container>
        <el-header>
          <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
            <el-menu-item index="/index">首页</el-menu-item>
<!--            <el-menu-item index="/article">分类</el-menu-item>-->
            <el-submenu index="/article">
              <template slot="title">分类</template>
              <!--:index="'/article/category/'+cate.categoryId"-->
              <el-menu-item @click="toArticleList(cate.id)" v-for="cate in categories" >{{cate.categoryName}}</el-menu-item>
            </el-submenu>
            <el-menu-item index="/pigeonhole">归档</el-menu-item>
            <el-menu-item index="/message">留言</el-menu-item>
            <el-menu-item index="/about">关于我</el-menu-item>
          </el-menu>
          <div class="line"></div>
        </el-header>
      </el-container>
    </div>
</template>

<script>
    export default {
      name: "Header",
      data() {
        return {
          activeIndex: this.$route.path,//当前路径
          categories: [],
          username: 'wuliang'
        }
      },
      methods: {
        //查询某一分类该作者所有文章
        getAll() {
          this.$http.get("http://localhost:8989/category").then((res) => {
            this.categories = res.data.categories;
          });
        },
        //去文章列表页
        toArticleList(categoryId) {
          console.log("Header categoryId===================="+categoryId);
          this.$router.push({
            path: '/article/category/'+categoryId,
            params: {categoryId: categoryId}});//params~post,query~get
        },
        handleSelect(key, keyPath) {
          //console.log(key, keyPath);
          this.$router.push(key)
        }
      },
      components: {},
      //在创建vue对象时，当html渲染之前就触发；但是注意，全局vue.js不强制刷新或者重启时只创建一次，也就是说，created()只会触发一次；
      created(){
        this.getAll();
      },
      //用来监听
      watch: {

      }
    }
</script>

<style scoped= lang="scss">

</style>
