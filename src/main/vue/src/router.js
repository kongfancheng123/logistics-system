import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

let router = new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      meta: {
        title: '登录'
      },
      component: () => import('./views/login.vue'),
      alias: '/login'
    },
    {
      path: '/game',
      component: () => import('./views/index.vue'),
      children: [
        {
          path: '/game',
          name: 'game',
          meta: {
            title: '赛事'
          },
          component: () => import('./views/comprehensive/game.vue')
        },
        {
            path: '/team',
                name: 'team',
            meta: {
            title: '战队'
            },
            component: () => import('./views/comprehensive/team.vue')
        },
        {
            path: '/news',
                name: 'news',
            meta: {
            title: '新闻'
            },
            component: () => import('./views/comprehensive/news.vue')
        },
        {
            path: '/user',
                name: 'user',
            meta: {
            title: '用户'
            },
            component: () => import('./views/comprehensive/user.vue')
        }
      ]
    },

    {
      path: '*',
      name: 'Error',
      meta: {
        title: '404页面不存在'
      },
      component: () => import('./views/404.vue')
    }
  ]
})

// 全局路由卫士，设置文档title
router.beforeEach((to, from, next) => {
  document.title = to.meta.title
  next()
})

export default router
