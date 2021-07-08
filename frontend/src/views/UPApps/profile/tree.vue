<!-- =========================================================================================
    File Name: ChartLineChart.vue
    Description: Create line chart
    ----------------------------------------------------------------------------------------
    Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
      Author: Pixinvent
    Author URL: http://www.themeforest.net/user/pixinvent
========================================================================================== -->


<template>
  <vx-card title="个人画像" class="mb-base" code-toggler>
    <div class="mt-5">
      <e-charts autoresize :options="tree"  ref="radar" auto-resize />
    </div>

    <template slot="codeContainer">
      &lt;template&gt;
      &lt;e-charts autoresize :options=&quot;tree&quot; ref=&quot;radar&quot; auto-resize /&gt;
      &lt;/template&gt;
      &lt;script&gt;
      import ECharts from 'vue-echarts/components/ECharts'
      import 'echarts/lib/component/tooltip'
      import 'echarts/lib/component/legend'
      import 'echarts/lib/chart/tree'
      import VueApexCharts from "vue-apexcharts";


      export default {
      data()
      {
      let datasets = [this.$store.state.searchdata]
      return {
      tree: {
      tooltip: {
      trigger: 'item',
      triggerOn: 'mousemove'
      },
      series: [
      {
      type: 'tree',
      data: datasets,
      top: '18%',
      bottom: '14%',
      layout: 'radial',
      symbol: 'emptyCircle',
      symbolSize: 7,
      initialTreeDepth: 4,
      animationDurationUpdate: 750,
      emphasis: {
      focus: 'descendant'
      }
      }
      ]
      }
      }
      }
      components: {
      ECharts,
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
  import 'echarts/lib/chart/tree'


  export default {
    data() {

      let datasets = [this.$store.state.searchdata]
      return {
        tree: {
            tooltip: {
              trigger: 'item',
              triggerOn: 'mousemove'
            },
            series: [
              {
                type: 'tree',

                data: datasets,

                top: '18%',
                bottom: '14%',

                layout: 'radial',

                symbol: 'emptyCircle',

                symbolSize: 7,

                initialTreeDepth: 4,

                animationDurationUpdate: 750,

                emphasis: {
                  focus: 'descendant'
                }
              }
            ]
        }
      }
    },
    components: {
      ECharts,
    },
  }
</script>
