<template>
    <div>
      <Header></Header>
      <router-view v-if="isRouterAlive"></router-view>
      <Footer></Footer>
    </div>
</template>

<script>
    import Header from "../components/Header";
    import Footer from "../components/Footer";
    export default {
      name: "Home",
      components: {Footer, Header},//组件加载
      provide (){
        return {
          reload:this.reload
        }
      },
      data(){
        return {
          isRouterAlive:true
        }
      },
      methods:{
        reload (){
          this.isRouterAlive = false
          this.$nextTick(function(){
            this.isRouterAlive = true
          })
        }
      }
    }
</script>

<style scoped>

</style>
