import Vue from 'vue'
import Router from 'vue-router'
import auth from "@/auth/authService";

import firebase from 'firebase/app'
import 'firebase/auth'

Vue.use(Router)

//解决编程式路由往同一地址跳转时会报错的情况
const originalPush = Router.prototype.push;
const originalReplace = Router.prototype.replace;
//push
Router.prototype.push = function push(location, onResolve, onReject) {
  if (onResolve || onReject)
    return originalPush.call(this, location, onResolve, onReject);
  return originalPush.call(this, location).catch(err => err);
};
//replace
Router.prototype.replace = function push(location, onResolve, onReject) {
  if (onResolve || onReject)
    return originalReplace.call(this, location, onResolve, onReject);
  return originalReplace.call(this, location).catch(err => err);
};





const router = new Router({
  mode: "history",
  base: process.env.BASE_URL,
  scrollBehavior () {
    return { x: 0, y: 0 }
  },
  routes: [
    // 基础标签路由


    {
      path: "",
      component: () => import("./layouts/main/Main.vue"),
      children: [
        {
          path: "/",
          redirect: "pages/login"
        },
         {
          path: "/home/datavisualization",
          name: "home-datavisualization",
          component: () => import('./views/DashboardAnalytics.vue'),
         meta: {
             rule: 'editor',
             // authRequired:true,
         }
        },
        // 显示标签的路由
        // 人口属性：性别、年龄段、身高、民族、籍贯、政治面貌、职业、婚姻情况
        // 学历、就业状况、星座、所在商圈、国籍
        {
          path: "/home/Label/genderList",
          name: "Label-genderList",
          component: () => import("@/views/UPApps/label/genderList.vue"),
          meta: {
           breadcrumb: [
               { title: 'Home', url: '/home/datavisualization' },
               { title: '电商'},
               { title: '综合'},
               { title: '人口属性'},
               { title: '性别', active: true },
           ],
           pageTitle: '性别',
           rule: 'editor'
          }
        },
        {
          path: "/home/Label/ageList",
          name: "Label-ageList",
          component: () => import("@/views/UPApps/label/ageList.vue"),
          meta: {
            breadcrumb: [
               { title: 'Home', url: '/home/datavisualization' },
               { title: '电商'},
               { title: '综合'},
               { title: '人口属性'},
               { title: '年龄段', active: true },
           ],
           pageTitle: '年龄段',
           rule: 'editor'
               }
        },
        {
          path: "/home/Label/heightList",
          name: "Label-heightList",
          component: () => import("@/views/UPApps/label/heightList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '人口属性'},
              { title: '身高', active: true },
            ],
            pageTitle: '身高',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label/nationList",
          name: "Label-nationList",
          component: () => import("@/views/UPApps/label/nationList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '人口属性'},
              { title: '民族', active: true },
            ],
            pageTitle: '民族',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label/hometownList",
          name: "Label-hometownList",
          component: () => import("@/views/UPApps/label/hometownList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '人口属性'},
              { title: '籍贯', active: true },
            ],
            pageTitle: '籍贯',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label/politicList",
          name: "Label-politicList",
          component: () => import("@/views/UPApps/label/politicList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '人口属性'},
              { title: '政治面貌', active: true },
            ],
            pageTitle: '政治面貌',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label/jobList",
          name: "Label-jobList",
          component: () => import("@/views/UPApps/label/jobList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '人口属性'},
              { title: '职业', active: true },
            ],
            pageTitle: '职业',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label/marriageList",
          name: "Label-marriageList",
          component: () => import("@/views/UPApps/label/marriageList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '人口属性'},
              { title: '婚姻状况', active: true },
            ],
            pageTitle: '婚姻状况',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label/educationList",
          name: "Label-educationList",
          component: () => import("@/views/UPApps/label/educationList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '人口属性'},
              { title: '学历', active: true },
            ],
            pageTitle: '学历',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label/employmentList",
          name: "Label-employmentList",
          component: () => import("@/views/UPApps/label/employmentList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '人口属性'},
              { title: '就业状况', active: true },
            ],
            pageTitle: '就业状况',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label/constellationList",
          name: "Label-constellationList",
          component: () => import("@/views/UPApps/label/constellationList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '人口属性'},
              { title: '星座', active: true },
            ],
            pageTitle: '星座',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label/businessDistrictList",
          name: "Label-businessDistrictList",
          component: () => import("@/views/UPApps/label/businessDistrictList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '人口属性'},
              { title: '所在商圈', active: true },
            ],
            pageTitle: '所在商圈',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label/countryList",
          name: "Label-countryList",
          component: () => import("@/views/UPApps/label/countryList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '人口属性'},
              { title: '国籍', active: true },
            ],
            pageTitle: '国籍',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label2/consCycleList",
          name: "Label2-consCycleList",
          component: () => import("@/views/UPApps/label2/consCycleList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '商业属性'},
              { title: '消费周期', active: true },
            ],
            pageTitle: '消费周期',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label2/consPowerList",
          name: "Label2-consPowerList",
          component: () => import("@/views/UPApps/label2/consPowerList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '商业属性'},
              { title: '消费能力', active: true },
            ],
            pageTitle: '消费能力',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label2/unitPriceList",
          name: "Label2-unitPriceList",
          component: () => import("@/views/UPApps/label2/unitPriceList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '商业属性'},
              { title: '客单价', active: true },
            ],
            pageTitle: '客单价',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label2/payMethodList",
          name: "Label2-payMethodList",
          component: () => import("@/views/UPApps/label2/payMethodList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '商业属性'},
              { title: '支付方式', active: true },
            ],
            pageTitle: '支付方式',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label2/singleHighestList",
          name: "Label2-singleHighestList",
          component: () => import("@/views/UPApps/label2/singleHighestList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '商业属性'},
              { title: '单笔最高', active: true },
            ],
            pageTitle: '单笔最高',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label2/purchaseFreqList",
          name: "Label2-purchaseFreqList",
          component: () => import("@/views/UPApps/label2/purchaseFreqList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '商业属性'},
              { title: '购买频率', active: true },
            ],
            pageTitle: '购买频率',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label2/returnRateList",
          name: "Label2-returnRateList",
          component: () => import("@/views/UPApps/label2/returnRateList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '商业属性'},
              { title: '退货率', active: true },
            ],
            pageTitle: '退货率',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label2/exchangeRateList",
          name: "Label2-exchangeRateList",
          component: () => import("@/views/UPApps/label2/exchangeRateList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '商业属性'},
              { title: '换货率', active: true },
            ],
            pageTitle: '换货率',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label2/moneySaverList",
          name: "Label2-moneySaverList",
          component: () => import("@/views/UPApps/label2/moneySaverList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '商业属性'},
              { title: '省钱小能手', active: true },
            ],
            pageTitle: '省钱小能手',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label2/couponList",
          name: "Label2-couponList",
          component: () => import("@/views/UPApps/label2/couponList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '商业属性'},
              { title: '有券必买', active: true },
            ],
            pageTitle: '有券必买',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label2/consultFreqList",
          name: "Label2-consultFreqList",
          component: () => import("@/views/UPApps/label2/consultFreqList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '商业属性'},
              { title: '客服咨询频率', active: true },
            ],
            pageTitle: '客服咨询频率',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label3/recentLoginList",
          name: "Label3-recentLoginList",
          component: () => import("@/views/UPApps/label3/recentLoginList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '行为属性'},
              { title: '最近登录', active: true },
            ],
            pageTitle: '最近登录',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label3/pageBrowsedList",
          name: "Label3-pageBrowsedList",
          component: () => import("@/views/UPApps/label3/pageBrowsedList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '行为属性'},
              { title: '浏览页面', active: true },
            ],
            pageTitle: '浏览页面',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label3/timeBrowsedList",
          name: "Label3-timeBrowsedList",
          component: () => import("@/views/UPApps/label3/timeBrowsedList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '行为属性'},
              { title: '浏览时长', active: true },
            ],
            pageTitle: '浏览时长',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label3/visitFreqList",
          name: "Label3-visitFreqList",
          component: () => import("@/views/UPApps/label3/visitFreqList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '行为属性'},
              { title: '访问频率', active: true },
            ],
            pageTitle: '访问频率',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label3/equipmentList",
          name: "Label3-equipmentList",
          component: () => import("@/views/UPApps/label3/equipmentList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '行为属性'},
              { title: '设备类型', active: true },
            ],
            pageTitle: '设备类型',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label3/browsePeriodList",
          name: "Label3-browsePeriodList",
          component: () => import("@/views/UPApps/label3/browsePeriodList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '行为属性'},
              { title: '浏览时段', active: true },
            ],
            pageTitle: '浏览时段',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label3/loginFreqList",
          name: "Label3-loginFreqList",
          component: () => import("@/views/UPApps/label3/loginFreqList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '行为属性'},
              { title: '登录频率', active: true },
            ],
            pageTitle: '登录频率',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label3/preferredCategoryList",
          name: "Label3-preferredCategoryList",
          component: () => import("@/views/UPApps/label3/preferredCategoryList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '行为属性'},
              { title: '品类偏好', active: true },
            ],
            pageTitle: '品类偏好',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label3/preferredBrandList",
          name: "Label3-preferredBrandList",
          component: () => import("@/views/UPApps/label3/preferredBrandList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '行为属性'},
              { title: '品牌偏好', active: true },
            ],
            pageTitle: '品牌偏好',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label4/realEstateList",
          name: "Label4-realEstateList",
          component: () => import("@/views/UPApps/label4/realEstateList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '用户属性'},
              { title: '房产', active: true },
            ],
            pageTitle: '房产',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label4/propertyValueList",
          name: "Label4-propertyValueList",
          component: () => import("@/views/UPApps/label4/propertyValueList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '用户属性'},
              { title: '房产价值', active: true },
            ],
            pageTitle: '房产价值',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label4/carProdList",
          name: "Label4-carProdList",
          component: () => import("@/views/UPApps/label4/carProdList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '用户属性'},
              { title: '车产', active: true },
            ],
            pageTitle: '车产',
            rule: 'editor'
          }
        },
        {
          path: "/home/Label4/carValueList",
          name: "Label4-carValueList",
          component: () => import("@/views/UPApps/label4/carValueList.vue"),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '电商'},
              { title: '综合'},
              { title: '用户属性'},
              { title: '车产价值', active: true },
            ],
            pageTitle: '车产价值',
            rule: 'editor'
          }
        },

        // =============================================================================
        // label serach
        // =============================================================================
        {
          path: '/labelserach/comlabels',
          name: 'labelsearch-comlabels',
          component: () => import('@/views/UPApps/labelserach/comlabel.vue'),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '标签查询'},
              { title: '组合标签', active: true },
            ],
            pageTitle: '组合标签',
            rule: 'editor'
          },
        },
        {
          path: '/labelserach/labelserach',
          name: 'labelsearch-labelserach',
          component: () => import('@/views/UPApps/labelserach/labelserach.vue'),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '标签查询'},
              { title: '标签筛选', active: true },
            ],
            pageTitle: '标签删选',
            rule: 'editor'
          },
        },








        // =============================================================================
        // CHARTS & MAPS
        // =============================================================================

        {
          path: '/profile/personalprofile',
          name: 'profile-personalprofile',
          component: () => import('@/views/UPApps/profile/personalprofile.vue'),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '用户画像' },
              { title: '个人画像', active: true },
            ],
            pageTitle: '个人画像',
            rule: 'editor'
          },
        },
        {
          path: '/charts-and-maps/charts/echarts',
          name: 'extra-component-charts-echarts',
          component: () => import('@/views/UPApps/profile/echarts/Echarts.vue'),
          meta: {
            breadcrumb: [
              { title: 'Home', url: '/home/datavisualization' },
              { title: '用户画像' },
              { title: '群体画像', active: true },
            ],
            pageTitle: '群体画像',
            rule: 'editor'
          },
        },
      ]
    },
    {
      path: '',
      component: () => import('@/layouts/full-page/FullPage.vue'),
      children: [
        // =============================================================================
        // PAGES
        // =============================================================================
        {
          path: '/callback',
          name: 'auth-callback',
          component: () => import('@/views/Callback.vue'),
          meta: {
            rule: 'editor'
          }
        },
        {
          path: '/pages/login',
          name: 'page-login',
          component: () => import('@/views/pages/login/Login.vue'),
          meta: {
            rule: 'editor'
          }
        },
        {
          path: '/pages/error-404',
          name: 'page-error-404',
          component: () => import('@/views/pages/Error404.vue'),
          meta: {
            rule: 'editor'
          }
        },
        {
          path: '/pages/error-500',
          name: 'page-error-500',
          component: () => import('@/views/pages/Error500.vue'),
          meta: {
            rule: 'editor'
          }
        }
      ]
    },
    {
      path: '*',
      redirect: '/pages/error-404'
    }

  ]
})

router.afterEach(() => {
  // Remove initial loading
  const appLoading = document.getElementById('loading-bg')
  if (appLoading) {
    appLoading.style.display = "none";
  }
})

router.beforeEach((to, from, next) => {
  firebase.auth().onAuthStateChanged(() => {

    // get firebase current user
    const firebaseCurrentUser = firebase.auth().currentUser

    // If auth required, check login. If login fails redirect to login page

    if(to.meta.authRequired) {
      console.log("beforeEach executes")
      if (!(auth.isAuthenticated() || firebaseCurrentUser)) {
        router.push({ path: '/pages/login'}) //, query: { to: to.path } }
      }
    }

    return next()

  });

});

export default router
