<!-- =========================================================================================
	File Name: EchartsPieChart.vue
	Description: Create bar chart
	----------------------------------------------------------------------------------------
	Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
	Author: Pixinvent
	Author URL: http://www.themeforest.net/user/pixinvent
========================================================================================== -->


<template>
	<vx-card title="年龄段" class="mb-base" code-toggler>

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
            color: ['#FF9F43','#28C76F','#82F67C','#90A67C','#B2867C','#G28F6C','#2DF67C','#8F67C9'],
            data: [
               { value: 0, name: '50后' },
               { value: 8, name: '60后' },
                { value: 270, name: '70后' },
                { value: 253, name: '80后' },
                { value: 292, name: '90后' },
                { value: 172, name: '00后' },
                { value: 0, name: '10后' },
                { value: 0, name: '20后' }
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
                },
              series: [
                {
                  name: 'Access source',
                  type: 'pie',
                  radius: '55%',
                  center: ['50%', '60%'],
                  color: ['#FF9F43','#28C76F','#82F67C','#90A67C','#B2867C','#G28F6C','#2DF67C','#8F67C9'],
                  data: [
                    { value: 0, name: '50后' },
                    { value: 8, name: '60后' },
                    { value: 270, name: '70后' },
                    { value: 253, name: '80后' },
                    { value: 292, name: '90后' },
                    { value: 172, name: '00后' },
                    { value: 0, name: '10后' },
                    { value: 0, name: '20后' }
                  ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }]
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
