<template>
  <el-container>
    <h1>留言列表</h1>
    <table border="1">
      <tr>
        <td>编号</td>
        <td>留言者</td>
        <td>内容</td>
        <td>时间</td>
        <td>操作</td>
      </tr>
      <tr v-for="msg in messages">
        <td>{{ msg.id }}</td>
        <td>{{ msg.username }}</td>
        <td>{{ msg.content }}</td>
        <td>{{ msg.createTime }}</td>
        <td><a href="javascript:;" @click="delRow(msg.id)">删除</a> <a :href="'/message/edit?id='+msg.id">修改</a></td>
      </tr>
    </table>
    <a href="/message/add">添加</a>
  </el-container>
</template>

<script>
    export default {
      name: "Message",
      data() {
        return {
          messages: []
        }
      },
      methods: {
        findAll() {//查询所有
          this.$http.get("http://localhost:8989/message/").then((res) => {
            this.messages = res.data.messages;
          });
        },
        delRow(id){
          console.log(id);
          this.$http.get("http://localhost:8989/message/delete?id="+id).then(res=>{
            console.log(res);
            if(res.data.result.flag){
              alert(res.data.msg+",点击确定刷新当前数据!");
              this.findAll();//查询所有
            }
          });
        }
      },
      components: {},
      created(){
        this.findAll();
      },
      watch: {  //用来监听
        $route: {
          handler: function(val, oldVal){
            console.log(val);
            if(val.path=='/message'){
              this.findAll();
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
