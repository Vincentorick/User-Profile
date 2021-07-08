<!-- =========================================================================================
	File Name: EchartsPieChart.vue
	Description: Create bar chart
	----------------------------------------------------------------------------------------
	Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
	Author: Pixinvent
	Author URL: http://www.themeforest.net/user/pixinvent
========================================================================================== -->


<template>
	<vx-card title="设备类型" class="mb-base" code-toggler>

		<div class="mt-5">
			<e-charts autoresize :options="pie" ref="pie" auto-resize />
		</div>

		<template slot="codeContainer">
&lt;template&gt;
  &lt;e-charts autoresize :options=&quot;pie&quot; ref=&quot;pie&quot; auto-resize /&gt;
&lt;/template&gt;

&lt;script&gt;
import ECharts from 'vue-echarts/components/ECharts'
import 'echarts/lib/component/tooltip'
import 'echarts/lib/component/legend'
import 'echarts/lib/chart/pie'

export default {
  data() {
    return {
      pie:{
        tooltip: {
          trigger: 'item',
          formatter: '{a} &lt;br/&gt;{b} : {c} ({d}%)'
        },
        legend: {
          orient: 'vertical',
          left: 'left',
          data: ['Direct interview', 'Email marketing', 'Alliance advertising', 'Video ad', 'Search engine']
        },
      series: [
      {
      name: 'Access source',
      type: 'pie',
      radius: '55%',
      center: ['50%', '60%'],
      color: ['#FF9F43','#a883a7','#28131a','#7d6e42','#330707','#16195d', "#b8ab90"],
      data: [
      { value: 197668, name: 'Windows' },
      { value: 1000, name: 'Mac' },
      { value: 6967, name: 'Linux' },
      { value: 131334, name: 'Android' },
      { value: 41014, name: 'IOS' }
      ],
      itemStyle: {
      emphasis: {
      shadowBlur: 10,
      shadowOffsetX: 0,
      shadowColor: 'rgba(0, 0, 0, 0.5)'
      }
      }
      }
      ]
      },
    }
  },
  components: {
    ECharts
  },
  mounted () {
    let dataIndex = -1
    let pie = this.$refs.pie
    let dataLen = pie.options.series[0].data.length
    setInterval(() =&gt; {
      pie.dispatchAction({
        type: 'downplay',
        seriesIndex: 0,
        dataIndex
      })
      dataIndex = (dataIndex + 1) % dataLen
      pie.dispatchAction({
        type: 'highlight',
        seriesIndex: 0,
        dataIndex
      })
      pie.dispatchAction({
        type: 'showTip',
        seriesIndex: 0,
        dataIndex
      })
    }, 1000)
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
import 'echarts/lib/chart/pie'

export default {
    data() {
        return {
            pie: {
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: ['Direct interview', 'Email marketing', 'Alliance advertising', 'Video ad', 'Search engine']
                },series: [
                {
                  name: 'Access source',
                  type: 'pie',
                  radius: '55%',
                  center: ['50%', '60%'],
                  color: ['#FF9F43','#00ff00','#28131a','#7d6e42','#330707','#16195d', "#b8ab90"],
                  data: [
                    { value: 197668, name: 'Windows' },
                    { value: 20000, name: 'Mac' },
                    { value: 6967, name: 'Linux' },
                    { value: 131334, name: 'Android' },
                    { value: 41014, name: 'IOS' }
                  ],
                  itemStyle: {
                    emphasis: {
                      shadowBlur: 10,
                      shadowOffsetX: 0,
                      shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                  }
                }
              ]
            },
        }
    },
    components: {
        ECharts
    },
    mounted() {
        let dataIndex = -1
        let pie = this.$refs.pie
        let dataLen = pie.options.series[0].data.length
        setInterval(() => {
            pie.dispatchAction({
                type: 'downplay',
                seriesIndex: 0,
                dataIndex
            })
            dataIndex = (dataIndex + 1) % dataLen
            pie.dispatchAction({
                type: 'highlight',
                seriesIndex: 0,
                dataIndex
            })
            pie.dispatchAction({
                type: 'showTip',
                seriesIndex: 0,
                dataIndex
            })
        }, 1000)
    }
}
</script>
