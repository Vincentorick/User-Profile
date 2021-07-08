<!-- =========================================================================================
	File Name: EchartsPieChart.vue
	Description: Create bar chart
	----------------------------------------------------------------------------------------
	Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
	Author: Pixinvent
	Author URL: http://www.themeforest.net/user/pixinvent
========================================================================================== -->


<template>
	<vx-card title="星座" class="mb-base" code-toggler>

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
      color: ['#FF9F43','#28C76F','#58C06A','#7d6e42','#d33ab3','#298170','#542400','#f2feb7','#a8b1d2','#54f97e','#181431','#db32d3'],
      data: [
      { value: 73, name: '白羊座' },
      { value: 97, name: '金牛座' },
      { value: 86, name: '双子座' },
      { value: 78, name: '巨蟹座' },
      { value: 80, name: '狮子座' },
      { value: 74, name: '处女座' },
      { value: 80, name: '天秤座' },
      { value: 71, name: '天蝎座' },
      { value: 59, name: '射手座' },
      { value: 83, name: '摩羯座' },
      { value: 99, name: '水瓶座' },
      { value: 70, name: '双鱼座' }
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
                  color: ['#FF9F43','#28C76F','#58C06A','#7d6e42','#d33ab3','#298170','#542400','#f2feb7','#a8b1d2','#54f97e','#181431','#db32d3'],
                  data: [
                    { value: 73, name: '白羊座' },
                    { value: 97, name: '金牛座' },
                    { value: 86, name: '双子座' },
                    { value: 78, name: '巨蟹座' },
                    { value: 80, name: '狮子座' },
                    { value: 74, name: '处女座' },
                    { value: 80, name: '天秤座' },
                    { value: 71, name: '天蝎座' },
                    { value: 59, name: '射手座' },
                    { value: 83, name: '摩羯座' },
                    { value: 99, name: '水瓶座' },
                    { value: 70, name: '双鱼座' }
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
