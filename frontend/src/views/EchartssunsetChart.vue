<!-- =========================================================================================
	File Name: ChartLineChart.vue
	Description: Create bar chart
	----------------------------------------------------------------------------------------
	Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
	Author: Pixinvent
	Author URL: http://www.themeforest.net/user/pixinvent
========================================================================================== -->


<template>
  <vx-card title="标签分级情况" class="mb-base" code-toggler>

    <div class="mt-5" style="width: 100%; height: 1200px">
      <e-charts autoresize :options="sunbrust" theme="ovilia-green" style="width: 100%; height: 100%;" auto-resize />
    </div>

    <template       slot="codeContainer">

      &lt;template&gt;
      &lt;e-charts autoresize :options=&quot;sunbrust&quot; theme=&quot;ovilia-green&quot; ref=&quot;line&quot; auto-resize /&gt;
      &lt;/template&gt;

      &lt;script&gt;
      import ECharts from 'vue-echarts/components/ECharts'
      import 'echarts/lib/component/tooltip'
      import 'echarts/lib/component/legend'
      import 'echarts/lib/chart/sunburst'
      import theme from './UPApps/profile/echarts/theme.json'

      import VueApexCharts from "vue-apexcharts";

      ECharts.registerTheme('ovilia-green', theme)

      export default {
      data() {
      let  data = [{
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }, {
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }, {
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }, {
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }, {
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }, {
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }, {
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }, {
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }, {
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }, {
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }, {
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }, {
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }, {
      "name": "电商",
      "value": 14,
      "itemStyle": {
      "color": "#2ec7c9"
      },
      "children": [{
      "name": "综合",
      "value": 14,
      "itemStyle": {
      "color": "#b6a2de"
      },
      "children": [{
      "name": "人口属性",
      "value": 14,
      "itemStyle": {
      "color": "#5ab1ef"
      },
      "children": [{
      "name": "性别",
      "value": 2,
      "itemStyle": {
      "color": "#ffb980"
      },
      "children": [{
      "name": "男",
      "value": 1,
      "itemStyle": {
      "color": "#d87a80"
      }
      }, {
      "name": "女",
      "value": 1,
      "itemStyle": {
      "color": "#e5cf0d"
      }
      }]
      }, {
      "name": "年龄段",
      "value": 8,
      "itemStyle": {
      "color": "#95706d"
      },
      "children": [{
      "name": "50后",
      "value": 1,
      "itemStyle": {
      "color": "#97b552"
      }
      }, {
      "name": "60后",
      "value": 1,
      "itemStyle": {
      "color": "#95706d"
      }
      }, {
      "name": "70后",
      "value": 1,
      "itemStyle": {
      "color": "#dc69aa"
      }
      }, {
      "name": "80后",
      "value": 1,
      "itemStyle": {
      "color": "#07a2a4"
      }
      }, {
      "name": "90后",
      "value": 1,
      "itemStyle": {
      "color": "#9a7fd1"
      }
      }, {
      "name": "00后",
      "value": 1,
      "itemStyle": {
      "color": "#588dd5"
      }
      }, {
      "name": "10后",
      "value": 1,
      "itemStyle": {
      "color": "#f5994e"
      }
      }, {
      "name": "20后",
      "value": 1,
      "itemStyle": {
      "color": "#c05050"
      }
      }]
      }, {
      "name": "身高",
      "value": 4,
      "itemStyle": {
      "color": "#c9ab00"
      },
      "children": [{
      "name": "150-159",
      "value": 1,
      "itemStyle": {
      "color": "#59678c"
      }
      }, {
      "name": "160-169",
      "value": 1,
      "itemStyle": {
      "color": "#c9ab00"
      }
      }, {
      "name": "170-179",
      "value": 1,
      "itemStyle": {
      "color": "#7eb00a"
      }
      }, {
      "name": "180-189",
      "value": 1,
      "itemStyle": {
      "color": "#6f5553"
      }
      }]
      }]
      }]
      }]
      }]
      let colors = [
      "#2ec7c9",
      "#b6a2de",
      "#5ab1ef",
      "#ffb980",
      "#d87a80",
      "#8d98b3",
      "#e5cf0d",
      "#97b552",
      "#95706d",
      "#dc69aa",
      "#07a2a4",
      "#9a7fd1",
      "#588dd5",
      "#f5994e",
      "#c05050",
      "#59678c",
      "#c9ab00",
      "#7eb00a",
      "#6f5553",
      "#c14089"
      ],

      return {
      sunbrust: {
      color: colors,

      title: {
      text: '2019年阅读分类统计',
      textStyle: {
      fontSize: 30,
      align: 'center',
      textShadowColor: 'rgba(0,0,0,0.3)',
      textShadowBlur: 3,
      },
      subtextStyle: {
      align: 'center',
      color:'#DDD',
      fontSize:18,
      textShadowColor: 'rgba(0,0,0,0.3)',
      textShadowBlur: 5,
      },
      },
      tooltip: {},

      series: {
      type: 'sunburst',
      highlightPolicy: 'descendant',
      data: data,
      radius: [0, 500],
      sort: null,
      center:['50%','45%'],
      levels: [{}, {
      //年份
      r0: '0%',
      r: '10%',
      itemStyle: {
      borderWidth: 2,

      },
      label: {
      rotate: 'tangential',
      fontSize:14
      },
      highlight: {
      itemStyle: {
      color: 'orange'
      }
      },
      downplay: {
      itemStyle: {
      color: '#ccc'
      }
      }
      }, {
      //分类
      r0: '10%',
      r: '25%',
      itemStyle: {
      borderWidth: 2,
      opacity:1

      },
      label: {
      align: 'right',
      fontSize: 12
      },
      highlight: {
      itemStyle: {
      color: 'orange'
      }
      },
      downplay: {
      itemStyle: {
      color: '#ccc'
      }
      }
      }, {
      //国家
      r0: '25%',
      r: '40%',
      label: {
      //position: 'outside',
      //padding: 3,
      //silent: false
      align: 'left',
      fontSize: 12
      },
      itemStyle: {
      //borderWidth: 3
      opacity:0.8
      },
      highlight: {
      itemStyle: {
      color: 'orange'
      }
      },
      downplay: {
      itemStyle: {
      color: '#ccc'
      }
      }
      }, {
      //作者
      r0: '40%',
      r: '65%',
      label: {
      //position: 'outside',
      padding: 0,
      align: 'right',
      fontSize: 10
      },
      itemStyle: {
      borderWidth: 1,
      opacity: 0.1,
      },
      highlight: {
      itemStyle: {
      color: 'orange'
      }
      },
      downplay: {
      itemStyle: {
      color: '#ccc'
      }
      }
      }, {
      //名字
      r0: '65%',
      r: '66%',

      itemStyle: {
      //shadowBlur: 5,
      //shadowColor: colors[0]
      },
      label: {
      //position: 'outside',
      align:'left',
      textShadowBlur: 5,
      textShadowColor: '#333',
      fontSize: 14
      },
      downplay: {
      label: {
      opacity: 0
      }
      },
      highlight: {
      itemStyle: {
      color: 'orange',

      },
      label: {

      color: '#FFF',
      fontSize: 13
      }

      }
      }, {
      //day
      r0: '120%',
      r: '121%',
      show: false,
      label: {
      position: 'outside',
      //padding: 3,
      //silent: false
      fontSize: 9,
      opacity: 0
      },
      itemStyle: {
      //borderWidth: 3
      opacity: 0
      },
      highlight: {
      itemStyle: {
      color: 'orange'
      }
      },
      downplay: {
      itemStyle: {
      color: '#ccc'
      }
      }
      }]
      }
      },
      }
      },
      components: {
      ECharts,
      VueApexCharts,
      }
      }
      &lt;/script&gt;
    </template>
  </vx-card>
</template>

<script>
  import ECharts from 'vue-echarts/components/ECharts'
  import 'echarts/lib/component/tooltip'
  import 'echarts/lib/component/legend'
  import 'echarts/lib/chart/sunburst'
  import theme from './UPApps/profile/echarts/theme.json'

  import VueApexCharts from "vue-apexcharts";

  ECharts.registerTheme('ovilia-green', theme)

  export default {
    data() {
      let  data = [{
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }, {
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }, {
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }, {
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }, {
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }, {
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }, {
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }, {
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }, {
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }, {
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }, {
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }, {
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }, {
        "name": "电商",
        "value": 14,
        "itemStyle": {
          "color": "#2ec7c9"
        },
        "children": [{
          "name": "综合",
          "value": 14,
          "itemStyle": {
            "color": "#b6a2de"
          },
          "children": [{
            "name": "人口属性",
            "value": 14,
            "itemStyle": {
              "color": "#5ab1ef"
            },
            "children": [{
              "name": "性别",
              "value": 2,
              "itemStyle": {
                "color": "#ffb980"
              },
              "children": [{
                "name": "男",
                "value": 1,
                "itemStyle": {
                  "color": "#d87a80"
                }
              }, {
                "name": "女",
                "value": 1,
                "itemStyle": {
                  "color": "#e5cf0d"
                }
              }]
            }, {
              "name": "年龄段",
              "value": 8,
              "itemStyle": {
                "color": "#95706d"
              },
              "children": [{
                "name": "50后",
                "value": 1,
                "itemStyle": {
                  "color": "#97b552"
                }
              }, {
                "name": "60后",
                "value": 1,
                "itemStyle": {
                  "color": "#95706d"
                }
              }, {
                "name": "70后",
                "value": 1,
                "itemStyle": {
                  "color": "#dc69aa"
                }
              }, {
                "name": "80后",
                "value": 1,
                "itemStyle": {
                  "color": "#07a2a4"
                }
              }, {
                "name": "90后",
                "value": 1,
                "itemStyle": {
                  "color": "#9a7fd1"
                }
              }, {
                "name": "00后",
                "value": 1,
                "itemStyle": {
                  "color": "#588dd5"
                }
              }, {
                "name": "10后",
                "value": 1,
                "itemStyle": {
                  "color": "#f5994e"
                }
              }, {
                "name": "20后",
                "value": 1,
                "itemStyle": {
                  "color": "#c05050"
                }
              }]
            }, {
              "name": "身高",
              "value": 4,
              "itemStyle": {
                "color": "#c9ab00"
              },
              "children": [{
                "name": "150-159",
                "value": 1,
                "itemStyle": {
                  "color": "#59678c"
                }
              }, {
                "name": "160-169",
                "value": 1,
                "itemStyle": {
                  "color": "#c9ab00"
                }
              }, {
                "name": "170-179",
                "value": 1,
                "itemStyle": {
                  "color": "#7eb00a"
                }
              }, {
                "name": "180-189",
                "value": 1,
                "itemStyle": {
                  "color": "#6f5553"
                }
              }]
            }]
          }]
        }]
      }]
      let colors = [
        "#2ec7c9",
        "#b6a2de",
        "#5ab1ef",
        "#ffb980",
        "#d87a80",
        "#8d98b3",
        "#e5cf0d",
        "#97b552",
        "#95706d",
        "#dc69aa",
        "#07a2a4",
        "#9a7fd1",
        "#588dd5",
        "#f5994e",
        "#c05050",
        "#59678c",
        "#c9ab00",
        "#7eb00a",
        "#6f5553",
        "#c14089"
      ]

      return {
        sunbrust: {
          // backgroundColor: bgColor,
          color: colors,

          title: {
            text: '',
            textStyle: {
              fontSize: 30,
              align: 'center',
              textShadowColor: 'rgba(0,0,0,0.3)',
              textShadowBlur: 3,
            },
            subtextStyle: {
              align: 'center',
              color:'#DDD',
              fontSize:18,
              textShadowColor: 'rgba(0,0,0,0.3)',
              textShadowBlur: 5,
            },
          },
          tooltip: {},

          series: {
            type: 'sunburst',
            highlightPolicy: 'descendant',
            data: data,
            radius: [0, 500],
            sort: null,
            center:['50%','45%'],
            levels: [{}, {
              //年份
              r0: '0%',
              r: '10%',
              itemStyle: {
                borderWidth: 2,

              },
              label: {
                rotate: 'tangential',
                fontSize:14
              },
              highlight: {
                itemStyle: {
                  color: 'orange'
                }
              },
              downplay: {
                itemStyle: {
                  color: '#ccc'
                }
              }
            }, {
              //分类
              r0: '10%',
              r: '25%',
              itemStyle: {
                borderWidth: 2,
                opacity:1

              },
              label: {
                align: 'right',
                fontSize: 12
              },
              highlight: {
                itemStyle: {
                  color: 'orange'
                }
              },
              downplay: {
                itemStyle: {
                  color: '#ccc'
                }
              }
            }, {
              //国家
              r0: '25%',
              r: '40%',
              label: {
                //position: 'outside',
                //padding: 3,
                //silent: false
                align: 'left',
                fontSize: 12
              },
              itemStyle: {
                //borderWidth: 3
                opacity:0.8
              },
              highlight: {
                itemStyle: {
                  color: 'orange'
                }
              },
              downplay: {
                itemStyle: {
                  color: '#ccc'
                }
              }
            }, {
              //作者
              r0: '40%',
              r: '65%',
              label: {
                //position: 'outside',
                padding: 0,
                align: 'right',
                fontSize: 10
              },
              itemStyle: {
                borderWidth: 1,
                opacity: 0.1,
              },
              highlight: {
                itemStyle: {
                  color: 'orange'
                }
              },
              downplay: {
                itemStyle: {
                  color: '#ccc'
                }
              }
            }, {
              //名字
              r0: '65%',
              r: '66%',

              itemStyle: {
                //shadowBlur: 5,
                //shadowColor: colors[0]
              },
              label: {
                //position: 'outside',
                align:'left',
                textShadowBlur: 5,
                textShadowColor: '#333',
                fontSize: 14
              },
              downplay: {
                label: {
                  opacity: 0
                }
              },
              highlight: {
                itemStyle: {
                  color: 'orange',

                },
                label: {

                  color: '#FFF',
                  fontSize: 13
                }

              }
            }, {
              //day
              r0: '120%',
              r: '121%',
              show: false,
              label: {
                position: 'outside',
                //padding: 3,
                //silent: false
                fontSize: 9,
                opacity: 0
              },
              itemStyle: {
                //borderWidth: 3
                opacity: 0
              },
              highlight: {
                itemStyle: {
                  color: 'orange'
                }
              },
              downplay: {
                itemStyle: {
                  color: '#ccc'
                }
              }
            }]
          }
        },
      }
    },
    components: {
      ECharts,
      VueApexCharts,
    }
  }
</script>
