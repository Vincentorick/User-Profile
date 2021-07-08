<!-- =========================================================================================
  File Name: DashboardAnalytics.vue
  Description: Dashboard Analytics
  ----------------------------------------------------------------------------------------
  Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
  Author: Pixinvent
  Author URL: http://www.themeforest.net/user/pixinvent
========================================================================================== -->

<template>
  <div id="dashboard-analytics">

         <echartssunset-chart></echartssunset-chart>
<!--    <div class="vx-row">-->

<!--      &lt;!&ndash; CARD 4: SESSION &ndash;&gt;-->
<!--      <div class="vx-col w-full md:w-1/2 mb-base">-->
<!--        <vx-card>-->
<!--          <div class="vx-row flex-col-reverse md:flex-col-reverse sm:flex-row lg:flex-row">-->

<!--          <vs-divider class="my-6"></vs-divider>-->
<!--          <div class="vx-row">-->
<!--            <div class="vx-col w-1/2 mb-3">-->
<!--              <p>Goal: $100000</p>-->
<!--              <vs-progress class="block mt-1" :percent="50" color="primary"></vs-progress>-->
<!--            </div>-->
<!--            <div class="vx-col w-1/2 mb-3">-->
<!--              <p>Users: 100K</p>-->
<!--              <vs-progress class="block mt-1" :percent="60" color="warning"></vs-progress>-->
<!--            </div>-->
<!--            <div class="vx-col w-1/2 mb-3">-->
<!--              <p>Retention: 90%</p>-->
<!--              <vs-progress class="block mt-1" :percent="70" color="danger"></vs-progress>-->
<!--            </div>-->
<!--            <div class="vx-col w-1/2 mb-3">-->
<!--              <p>Duration: 1yr</p>-->
<!--              <vs-progress class="block mt-1" :percent="90" color="success"></vs-progress>-->
<!--            </div>-->
<!--          </div>-->
<!--          </div>-->
<!--        </vx-card>-->
<!--      </div>-->
<!--    </div>-->

<!--        <div class="vx-row">-->

<!--        </div>-->
  </div>
</template>

<script>
import VueApexCharts from 'vue-apexcharts'
import EchartssunsetChart from "@/views/EchartssunsetChart";
// import StatisticsCardLine from '@/components/statistics-cards/StatisticsCardLine.vue'
// import analyticsData from './ui-elements/card/analyticsData.js'
// import ChangeTimeDurationDropdown from '@/components/ChangeTimeDurationDropdown.vue'
// import VxTimeline from "@/components/timeline/VxTimeline"

export default {
    data() {
        return {

        }
    },
    components: {
        VueApexCharts,
        EchartssunsetChart
       // StatisticsCardLine,
       // ChangeTimeDurationDropdown,
       // VxTimeline
    },
    created() {

    }
}
</script>

<style lang="scss">
/*! rtl:begin:ignore */
#dashboard-analytics {
  .greet-user{
    position: relative;

    .decore-left{
      position: absolute;
      left:0;
      top: 0;
    }
    .decore-right{
      position: absolute;
      right:0;
      top: 0;
    }
  }

  @media(max-width: 576px) {
    .decore-left, .decore-right{
      width: 140px;
    }
  }
}
/*! rtl:end:ignore */
</style>
