<!-- =========================================================================================
    File Name: Echarts.vue
    Description: Echarts (third-party) - Imports page portions
    ----------------------------------------------------------------------------------------
    Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
      Author: Pixinvent
    Author URL: http://www.themeforest.net/user/pixinvent
========================================================================================== -->

<template>
  <div id="dashboard-analytics">

    <el-input placeholder="请输入搜索的用户的邮箱" prefix-icon="el-icon-search" v-model="search_label" @keyup.enter.native="searchHandler"></el-input>
    <tree></tree>

  </div>
</template>

<script>
  import VueApexCharts from 'vue-apexcharts'
  import tree from './tree.vue'
  import EchartsRadarChart from './EchartsRadarChart'
export default {
  data(){
    return {
      search_label:'',
    }
  },
    methods:{
    getdata()
      {
        return this.$axios.get('http://localhost:8080/profile/getByEmail', this.search_label).then(res =>{
          this.$store.state.searchdata = res.data.data
          return res.data.data
        })
      },
      searchHandler(){
        this.$store.state.searchdata =  this.getdata()
        console.log("searchdata: ", this.getdata())
        }

    },
  components: {
    VueApexCharts,
    tree,
    EchartsRadarChart
  }
}
</script>
