<!-- =========================================================================================
	File Name: EchartsPieChart.vue
	Description: Create bar chart
	----------------------------------------------------------------------------------------
	Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
	Author: Pixinvent
	Author URL: http://www.themeforest.net/user/pixinvent
========================================================================================== -->


<template>
	<vx-card title="职业" class="mb-base" code-toggler>

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
      color: ['#FF9F43','#28C76F','#58C06A','#7d6e42','#d33ab3','#16195d'],
      data: [
      { value: 162, name: '学生' },
      { value: 145, name: '公务员' },
      { value: 202, name: '军人' },
      { value: 143, name: '警察' },
      { value: 130, name: '教师' },
      { value: 208, name: '白领' }
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
                  color: ['#FF9F43','#28C76F','#58C06A','#7d6e42','#d33ab3','#16195d'],
                  data: [
                    { value: 162, name: '学生' },
                    { value: 145, name: '公务员' },
                    { value: 202, name: '军人' },
                    { value: 143, name: '警察' },
                    { value: 130, name: '教师' },
                    { value: 208, name: '白领' }
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
