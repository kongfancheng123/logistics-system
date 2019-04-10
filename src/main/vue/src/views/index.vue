<template>
  <el-container>
    <!-- el-header -->
    <el-header id="salfmenu">
      <!-- leftbar -->
      <div class="leftbar">
        <img src="@/assets/logo.png"
             width="300">

        <!-- el-menu -->
        <el-menu router
                 :default-active="$route.path"
                 class="el-menu-demo"
                 mode="horizontal">
          <el-menu-item index="/game"
                        route>
            <i class="el-icon-picture"></i>赛事</el-menu-item>

          <el-menu-item index="/team"
                        route>
            <i class="el-icon-picture"></i>战队</el-menu-item>

          <el-menu-item index="/news"
                                    route>
            <i class="el-icon-picture"></i>新闻</el-menu-item>

          <el-menu-item index="/user"   v-if='user.isSuperUser===1'
                                               route>
             <i class="el-icon-picture"></i>用户</el-menu-item>

        </el-menu>
      </div>

    </el-header>

    <!-- el-main -->
    <el-main>
      <router-view></router-view>
    </el-main>

  </el-container>
</template>

<script>
export default {
  name: 'index',
  data() {
    return {}
  },
  created() {
        let vm = this
        vm.user = JSON.parse(vm.getCookie('user'))
        console.log(vm.user)
        //vm.getReadyData()
      },
     methods: {
          getCookie(name){
                    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
                    if(arr=document.cookie.match(reg)){
                      return unescape(arr[2]);
                    } else{
                     return null;}

                }

      }
}
</script>
<style>
.el-menu.el-menu--horizontal {
  border-bottom: none;
}
</style>


<style lang="scss">
#salfmenu {
  .el-submenu,
  .el-menu-item {
    background: #007ef3;
    border: none;
    color: #fff;
  }

  i {
    color: #fff;
  }

  .el-menu-item.is-active {
    border-bottom: none;
    color: #fff;
    background: #0084fe;
  }

  .el-submenu__title {
    color: #fff;
  }
  .el-submenu__title:hover {
    background: #0084fe;
  }
}
</style>


<style lang="scss" scoped>
.el-header {
  font-size: 24px;
  color: #fff;
  display: flex;
  background-color: #007ef3;
  line-height: 60px;
  justify-content: space-between;
  .leftbar {
    display: flex;
    align-items: center;
    img {
      flex-shrink: 0;
      height: 28px;
      margin-right: 30px;
    }
  }
}
</style>
