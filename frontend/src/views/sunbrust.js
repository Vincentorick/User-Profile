/*=========================================================================================
    File Name: apexChartData.vue
    Description: Data shown by charts
    ----------------------------------------------------------------------------------------
    Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
      Author: Pixinvent
    Author URL: http://www.themeforest.net/user/pixinvent
==========================================================================================*/
var colors = [
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
];
let bgColor={
  type: 'radial',
  x: 0.5,
  y: 0.5,
  r: 0.7,
  colorStops: [{
    offset: 0,
    color: '#b6a2de' // 0% 处的颜色
  }, {
    offset: .4,
    color: '#9a7fd1' // 100% 处的颜色
  }, {
    offset: 1,
    color: '#59678c' // 100% 处的颜色
  }],
  globalCoord: false // 缺省为 false
};
let dd = [];

function obj2string(o) {
  var r = [];
  if (typeof o == "string") {
    return "\"" + o.replace(/([\'\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
  }
  if (typeof o == "object") {
    if (!o.sort) {
      for (var i in o) {
        r.push(i + ":" + obj2string(o[i]));
      }
      if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) {
        r.push("toString:" + o.toString.toString());
      }
      r = "{" + r.join() + "}";
    } else {
      for (var i = 0; i < o.length; i++) {
        r.push(obj2string(o[i]))
      }
      r = "[" + r.join() + "]";
    }
    return r;
  }
  return o.toString();
};

export default {
  sunbrustChart: {
    series: {
      type: 'sunburst',
      highlightPolicy: 'descendant',
      data: [],
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
    },
    chartOptions: {
      chart: {
        height: 350,
        zoom: {
          enabled: false
        }
      },
      colors: colors,
      dataLabels: {
        enabled: false
      },
      stroke: {
        curve: 'straight'
      },
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
    }
  },
  sunbrustChartCode:
    `<template>
  <vue-apex-charts type="sunburst" height="350" :options="sunbrustChartCode.chartOptions" :series="sunbrustChartCode.series"></vue-apex-charts>
</template>

<script>
  data()
  {
    return
    {
     var colors = [
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
];
     sunbrustChart: {
    series: {
      type: 'sunburst',
      highlightPolicy: 'descendant',
      data: [],
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
    },
    chartOptions: {
      chart: {
        height: 350,
        zoom: {
          enabled: false
        }
      },
      colors: colors,
      dataLabels: {
        enabled: false
      },
      stroke: {
        curve: 'straight'
      },
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
    }
  }
    }
  }
</script>`,
}
