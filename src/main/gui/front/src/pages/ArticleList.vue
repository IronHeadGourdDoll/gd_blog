<template>

  <el-container>
    <h1>博客列表</h1>
    <table border="1">
      <tr>
        <td>编号</td>
        <td>作者</td>
        <td>分类</td>
        <td>内容</td>
        <td>时间</td>
        <td>阅读量</td>
        <td>操作</td>
      </tr>
      <tr v-for="bg in blogs">
        <td>{{ bg.id }}</td>
        <td>{{ bg.username }}</td>
        <td>{{ bg.categoryName }}</td>
        <td v-html="bg.content"></td>
        <td>{{ bg.createTime }}</td>
        <td>{{ bg.readTimes }}</td>

        <td><a href="javascript:;" @click="delRow(bg.id)">删除</a> <a :href="'/message/edit?id='+bg.id">修改</a></td>
      </tr>
    </table>
    <a href="/message/add">添加</a>
  </el-container>

</template>

<script>
    export default {
      name: "ArticleList",
      // inject:['reload'],
      data() {
        return {
          blogs: [],
          username: "wuliang",
          categoryId: 1
        }
      },
      methods: {
        getByUsernameAndCategory() {//查询
          this.categoryId=this.$route.params.categoryId
          console.log("articleList===================="+this.categoryId);
          //this.reload();
          this.$http.get("http://localhost:8989/"+this.username+"/article/category/"+this.categoryId).then((res) => {
            this.blogs = res.data.blogs;
            console.log("blogs==============================="+this.blogs);
          });
        },
      },
      components: {},
      created(){
        this.getByUsernameAndCategory();
      },
      //一进入页面就触发
      // activated(){
      //   if (this.$route.meta.isFresh) {
      //     this.getByUsernameAndCategory();
      //     init();
      //   }else{}
      //   this.$route.meta.isFresh = false;//记得这里一定要设置一下false。
      // },
      // beforeRouteEnter(to, from, next) {
      //   if (from.name == 'ArticleList') {
      //     this.getByUsernameAndCategory();
      //     to.meta.isFresh = true;
      //   }
      //   next();
      // },
      watch: {  //用来监听
        $route: {
          handler: function(val, oldVal){
            //console.log(val);
            if(val.path=='/article'){
              this.getByUsernameAndCategory();
            }
          },
          // 深度观察监听
          deep: true
        }
      },
    }
</script>

<style scoped>

</style>
