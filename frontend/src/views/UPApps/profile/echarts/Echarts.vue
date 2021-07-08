<!-- =========================================================================================
    File Name: Echarts.vue
    Description: Echarts (third-party) - Imports page portions
    ----------------------------------------------------------------------------------------
    Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
      Author: Pixinvent
    Author URL: http://www.themeforest.net/user/pixinvent
========================================================================================== -->

<template>
    <div id="extra-component-echarts-demo">
        <p class="mb-4">ECharts component for Vue.js. Read full documnetation <a href="https://github.com/ecomfe/vue-echarts" target="_blank" rel="nofollow">here</a></p>

        <div class="vx-row match-height">
<!--          <div class="vx-col w-full md:w-1/2">-->
<!--            <chartjs-line-chart1></chartjs-line-chart1>-->
<!--          </div>-->
            <div class="vx-col w-full">
              <echarts-pie-chart1></echarts-pie-chart1>
            </div>
          <div class="vx-col w-full">
            <echarts-pie-chart2></echarts-pie-chart2>
          </div>
          <div class="vx-col w-full">
            <echarts-pie-chart3></echarts-pie-chart3>
          </div>
          <div class="vx-col w-full">
            <echarts-pie-chart4></echarts-pie-chart4>
          </div>
          <div class="vx-col w-full">
            <echarts-pie-chart5></echarts-pie-chart5>
          </div>
<!--            <div class="vx-col w-full">-->
<!--                <echarts-radar-chart1></echarts-radar-chart1>-->
<!--            </div>-->
<!--          <div class="vx-col w-full">-->
<!--            <echarts-radar-chart2></echarts-radar-chart2>-->
<!--          </div>-->
<!--          <div class="vx-col w-full">-->
<!--            <echarts-radar-chart3></echarts-radar-chart3>-->
<!--          </div>-->
<!--          <div class="vx-col w-full">-->
<!--            <echarts-radar-chart4></echarts-radar-chart4>-->
<!--          </div>-->
<!--          <div class="vx-col w-full">-->
<!--            <echarts-radar-chart5></echarts-radar-chart5>-->
<!--          </div>-->
          <div class="vx-col w-full">
            <echarts-pie-chart6></echarts-pie-chart6>
          </div>
          <div class="vx-col w-full">

            <echarts-pie-chart7></echarts-pie-chart7>
          </div>
          <div class="vx-col w-full">
            <echarts-pie-chart8></echarts-pie-chart8>
          </div>
          <div class="vx-col w-full">
            <echarts-pie-chart9></echarts-pie-chart9>
          </div>
          <div class="vx-col w-full">
            <echarts-pie-chart10></echarts-pie-chart10>
          </div>

        </div>
    </div>
</template>

<script>
// import EchartsBarChart from './EchartsBarChart.vue'
// import ChartjsLineChart1 from "./ChartjsLineChart1.vue"
// import EchartsLineChart from './EchartsLineChart.vue'
// import EchartsPieChart from './EchartsPieChart.vue'
import EchartsPieChart1 from './EchartsPieChart1.vue'
import EchartsPieChart2 from './EchartsPieChart2.vue'
import EchartsPieChart3 from './EchartsPieChart3.vue'
import EchartsPieChart4 from './EchartsPieChart4.vue'
import EchartsPieChart5 from './EchartsPieChart5.vue'
import EchartsPieChart6 from './EchartsPieChart6.vue'
import EchartsPieChart7 from './EchartsPieChart7.vue'
import EchartsPieChart8 from './EchartsPieChart8.vue'
import EchartsPieChart9 from './EchartsPieChart9.vue'
import EchartsPieChart10 from './EchartsPieChart10.vue'
// import EchartsPolarChart from './EchartsPolarChart.vue'
// import EchartsScatterChart from './EchartsScatterChart.vue'
// import EchartsRadarChart from './EchartsRadarChart.vue'

export default {
    components: {
        EchartsPieChart1,
      EchartsPieChart2,
      EchartsPieChart3,
      EchartsPieChart4,
      EchartsPieChart5,
      EchartsPieChart6,
      EchartsPieChart7,
      EchartsPieChart8,
      EchartsPieChart9,
      EchartsPieChart10,

        // EchartsLineChart,
        // EchartsPieChart,
        // EchartsPolarChart,
        // EchartsScatterChart,
        // EchartsRadarChart,
    }
}
</script>
