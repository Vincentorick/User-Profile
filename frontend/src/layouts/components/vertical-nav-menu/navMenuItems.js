/*=========================================================================================
  File Name: sidebarItems.js
  Description: Sidebar Items list. Add / Remove menu items from here.
  Strucutre:
          url     => router path
          name    => name to display in sidebar
          slug    => router path name
          icon    => Feather Icon component/icon name
          tag     => text to display on badge
          tagColor  => class to apply on badge element
          i18n    => Internationalization
          submenu   => submenu of current item (current item will become dropdown )
                NOTE: Submenu don't have any icon(you can add icon if u want to display)
          isDisabled  => disable sidebar item/group
  ----------------------------------------------------------------------------------------
  Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
  Author: Pixinvent
  Author URL: http://www.themeforest.net/user/pixinvent
==========================================================================================*/


export default [
  {
    header: "标签概览",
    icon: "HomeIcon",
    items: [
      {
        url: "/home/datavisualization",
        name: "数据可视化",
        slug: "home-datavisulization",
        // icon: "MenuIcon"
      }
    ]
  },
  {
    header: "标签详情",
    icon: "MoreHorizontalIcon",
    items: [
      {
        url: "/home/LabelList",
        name: "电商",
        icon:"MenuIcon",
        submenu: [
          {
            url: null,
            name: "综合",
            submenu: [
              {
                url: null,
                name: "人口属性",
                submenu: [
                  {
                    url: "/home/Label/genderlist",
                    name: "性别",
                    slug:"Label-genderlist"
                  },
                  {
                    url: "/home/Label/ageList",
                    name: "年龄段",
                    slug: "Label-ageList",
                  },
                  {
                    url: "/home/Label/heightList",
                    name: "身高",
                    slug: "Label-heightList",
                  },
                  {
                    url: "/home/Label/nationList",
                    name: "民族",
                    slug: "Label-nationList",
                  },
                  {
                    url: "/home/Label/hometownList",
                    name: "籍贯",
                    slug: "Label-hometownList",
                  },
                  {
                    url: "/home/Label/politicList",
                    name: "政治面貌",
                    slug: "Label-politicList",
                  },
                  {
                    url: "/home/Label/jobList",
                    name: "职业",
                    slug: "Label-jobList",
                  },
                  {
                    url: "/home/Label/marriageList",
                    name: "婚姻状况",
                    slug: "Label-marriageList",
                  },
                  {
                    url: "/home/Label/educationList",
                    name: "学历",
                    slug: "Label-educationList",
                  },
                  {
                    url: "/home/Label/employmentList",
                    name: "就业",
                    slug: "Label-employmentList",
                  },
                  {
                    url: "/home/Label/constellationList",
                    name: "星座",
                    slug: "Label-constellationList",
                  },
                  {
                    url: "/home/Label/businessDistrictList",
                    name: "所在商圈",
                    slug: "Label-businessDistrictList",
                  },
                  {
                    url: "/home/Label/countryList",
                    name: "国籍",
                    slug: "Label-countryList",
                  },

                ]
              },
              {
                url: null,
                name: "商业属性",
                submenu: [
                  {
                    url: "/home/Label2/consCycleList",
                    name: "消费周期",
                    slug:"Label-consCycleList"
                  },
                  {
                    url: "/home/Label2/consPowerList",
                    name: "消费能力",
                    slug:"Label-consPowerList"
                  },
                  {
                    url: "/home/Label2/unitPriceList",
                    name: "客单价",
                    slug:"Label-unitPriceList"
                  },
                  {
                    url: "/home/Label2/payMethodList",
                    name: "支付方式",
                    slug:"Label-payMethodList"
                  },
                  {
                    url: "/home/Label2/singleHighestList",
                    name: "单笔最高",
                    slug:"Label-singleHighestList"
                  },
                  {
                    url: "/home/Label2/purchaseFreqList",
                    name: "购买频率",
                    slug:"Label-purchaseFreqList"
                  },
                  {
                    url: "/home/Label2/returnRateList",
                    name: "退货率",
                    slug:"Label-returnRateList"
                  },
                  {
                    url: "/home/Label2/moneySaverList",
                    name: "省钱小能手",
                    slug:"Label-moneySaverList"
                  },
                  {
                    url: "/home/Label2/couponList",
                    name: "有券必买",
                    slug:"Label-couponList"
                  },
                  {
                    url: "/home/Label2/consultFreqList",
                    name: "客服咨询频率",
                    slug:"Label-consultFreqList"
                  },
                ]
              },
              {
                url: null,
                name: "行为属性",
                submenu: [
                  {
                    url: "/home/Label3/recentLoginList",
                    name: "最近登录",
                    slug:"Label-recentLoginList"
                  },
                  {
                    url: "/home/Label3/pageBrowsedList",
                    name: "浏览页面",
                    slug:"Label-pageBrowsedList"
                  },
                  {
                    url: "/home/Label3/timeBrowsedList",
                    name: "浏览时长",
                    slug:"Label-timeBrowsedList"
                  },
                  {
                    url: "/home/Label3/visitFreqList",
                    name: "访问频率",
                    slug:"Label-visitFreqList"
                  },
                  {
                    url: "/home/Label3/equipmentList",
                    name: "设备类型",
                    slug:"Label-equipmentList"
                  },
                  {
                    url: "/home/Label3/browsePeriodList",
                    name: "浏览时段",
                    slug:"Label-browsePeriodList"
                  },
                  {
                    url: "/home/Label3/loginFreqList",
                    name: "登录频率",
                    slug:"Label-loginFreqList"
                  },
                  {
                    url: "/home/Label3/preferredCategoryList",
                    name: "品类偏好",
                    slug:"Label-preferredCategoryList"
                  },
                  {
                    url: "/home/Label3/preferredBrandList",
                    name: "品牌偏好",
                    slug:"Label-preferredBrandList"
                  },
                ]
              },
              {
                url: null,
                name: "用户属性",
                submenu: [
                  {
                    url: "/home/Label4/realEstateList",
                    name: "房产",
                    slug:"Label-realEstateList"
                  },
                  {
                    url: "/home/Label4/propertyValueList",
                    name: "房产价值",
                    slug:"Label-propertyValueList"
                  },
                  {
                    url: "/home/Label4/carProdList",
                    name: "车产",
                    slug:"Label-carProdList"
                  },
                  {
                    url: "/home/Label4/carValueList",
                    name: "车产价值",
                    slug:"Label-carValueList"
                  },
                ]
              },
            ]
          },
        ]
      },

    ]
  },
  {header:"标签查询",
    icon:"MoreHorizontalIcon",
    items:[
      {
        url:"/labelserach/comlabels",
        name:"组合标签",
        slug:"label-search"
      },
      {
        url:"/labelserach/labelserach",
        name:"标签筛选",
        slug:"label-filter"
      },
    ]
  },
  {
    header: "用户画像",
    icon: "MoreHorizontalIcon",
    items:[

      {
        url:"/profile/personalprofile",
        name:"个人画像",
        slug:"profile-personprofile"
      },
      {
        url:"/charts-and-maps/charts/echarts",
        name:"群体画像",
        slug:"profile-peopleprofile"
      }
    ]
  }
]
