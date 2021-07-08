<template>

  <div id="page-user-list">
    <div class="vx-card p-6">

      <div class="flex flex-wrap items-center">

        <!-- ITEMS PER PAGE -->
        <div class="flex-grow">
          <vs-dropdown vs-trigger-click class="cursor-pointer">
            <div class="p-4 border border-solid d-theme-border-grey-light rounded-full d-theme-dark-bg cursor-pointer flex items-center justify-between font-medium">
              <span class="mr-2">{{ currentPage * paginationPageSize - (paginationPageSize - 1) }} - {{ usersData.length - currentPage * paginationPageSize > 0 ? currentPage * paginationPageSize : usersData.length }} of {{ usersData.length }}</span>
              <feather-icon icon="ChevronDownIcon" svgClasses="h-4 w-4" />
            </div>
            <vs-dropdown-menu>

              <vs-dropdown-item @click="gridApi.paginationSetPageSize(10)">
                <span>10</span>
              </vs-dropdown-item>
              <vs-dropdown-item @click="gridApi.paginationSetPageSize(20)">
                <span>20</span>
              </vs-dropdown-item>
              <vs-dropdown-item @click="gridApi.paginationSetPageSize(25)">
                <span>25</span>
              </vs-dropdown-item>
              <vs-dropdown-item @click="gridApi.paginationSetPageSize(30)">
                <span>30</span>
              </vs-dropdown-item>
            </vs-dropdown-menu>
          </vs-dropdown>
        </div>
        <vs-input class="sm:mr-4 mr-0 sm:w-auto w-full sm:order-normal order-3 sm:mt-0 mt-4" v-model="searchQuery" @input="updateSearchQuery" placeholder="Search..." />
      </div>


      <!-- AgGrid Table -->
      <ag-grid-vue
        ref="agGridTable"
        :components="components"
        :gridOptions="gridOptions"
        class="ag-theme-material w-100 my-4 ag-grid-table"
        :columnDefs="columnDefs"
        :defaultColDef="defaultColDef"
        :rowData="usersData"
        rowSelection="multiple"
        colResizeDefault="shift"
        :animateRows="true"
        :floatingFilter="true"
        :pagination="true"
        :paginationPageSize="paginationPageSize"
        :suppressPaginationPanel="true"
        :enableRtl="$vs.rtl">
      </ag-grid-vue>

      <vs-pagination
        :total="totalPages"
        :max="7"
        v-model="currentPage" />

    </div>
  </div>

</template>

<script>
  import { AgGridVue } from "ag-grid-vue"
  import '@/assets/scss/vuexy/extraComponents/agGridStyleOverride.scss'
  import vSelect from 'vue-select'

  // Store Module
 // import moduleUserManagement from '@/store/user-management/moduleUserManagement.js'

  //axios


  // Cell Renderer
  import CellRendererLink from "./cell-renderer/CellRendererLink.vue"
  import CellRendererStatus from "./cell-renderer/CellRendererStatus.vue"
  import CellRendererVerified from "./cell-renderer/CellRendererVerified.vue"
  import CellRendererActions from "./cell-renderer/CellRendererActions.vue"

  export default {
    components: {
      AgGridVue,
      vSelect,

      // Cell Renderer
      CellRendererLink,
      CellRendererStatus,
      CellRendererVerified,
      CellRendererActions,
    },
    data() {
      return {
        searchQuery: "",
        listdata:[],
        // AgGrid
        gridApi: null,
        gridOptions: {},
        defaultColDef: {
          sortable: true,
          resizable: true,
          suppressMenu: true
        },
        columnDefs: [
          {
            headerName: '属性值',
            field: 'value',
            width: 200,
            filter: true,
            checkboxSelection: true,
            headerCheckboxSelectionFilteredOnly: true,
            headerCheckboxSelection: true,
          },
          {
            headerName: '属性描述',
            field: 'discription',
            filter: true,
            width: 400,
          },
          {
            headerName: '拥有该标签用户数',
            field: 'count',
            filter: true,
            width: 200,
          },
          {
            headerName: '操作',
            field: 'transactions',
            width: 200,
            cellRendererFramework: 'CellRendererActions',
          },
        ],

        // Cell Renderer Components
        components: {
          CellRendererLink,
          CellRendererStatus,
          CellRendererVerified,
          CellRendererActions,
        }
      }
    },


    watch: {
       
    },
    computed: {
      usersData() {// 传入参数：pageid
         return this.listdata
      },
      paginationPageSize() {
        if(this.gridApi) return this.gridApi.paginationGetPageSize()
        else return 10
      },
      totalPages() {
        if(this.gridApi) return this.gridApi.paginationGetTotalPages()
        else return 0
      },
      currentPage: {
        get() {
          if(this.gridApi) return this.gridApi.paginationGetCurrentPage() + 1
          else return 1
        },
        set(val) {
          this.gridApi.paginationGoToPage(val - 1)
        }
      }
    },
    methods: {
      // getlist()
      //   {
      //   this.$axios.get('http://localhost:8080/tag/getLowLevel/' + this.$store.state.pageId.data['年龄段']).then(res=>{
      //     for (var i =0 ; i< res.data.length;i++){
      //       let data={
      //         value:res.data[i]['name'],
      //         discription:res.data[i]['business'],
      //         count: res.data[i]['count']
      //       }
      //       this.listdata.push(data)
      //     }
      //   })
      // },
      setColumnFilter(column, val) {
        const filter = this.gridApi.getFilterInstance(column)
        let modelObj = null

        if(val !== "all") {
          modelObj = { type: "equals", filter: val }
        }

        filter.setModel(modelObj)
        this.gridApi.onFilterChanged()
      },
      resetColFilters() {
        // Reset Grid Filter
        this.gridApi.setFilterModel(null)
        this.gridApi.onFilterChanged()

        // Reset Filter Options
        this.roleFilter = this.statusFilter = this.isVerifiedFilter = this.departmentFilter = { label: 'All', value: 'all' }

        this.$refs.filterCard.removeRefreshAnimation()
      },
      updateSearchQuery(val) {
        this.gridApi.setQuickFilter(val)
      }
    },
    mounted() {
      this.gridApi = this.gridOptions.api

      /* =================================================================
        NOTE:
        Header is not aligned properly in RTL version of agGrid table.
        However, we given fix to this issue. If you want more robust solution please contact them at gitHub
      ================================================================= */
      if(this.$vs.rtl) {
        const header = this.$refs.agGridTable.$el.querySelector(".ag-header-container")
        header.style.left = "-" + String(Number(header.style.transform.slice(11,-3)) + 9) + "px"
      }
    },
    created() {
      // 输入pageid作为参数
        this.$axios.get('http://localhost:8080/tag/getLowLevel/' + this.$store.state.pageId.data['购买频率']).then(res=>{
          for (var i =0 ; i< res.data.length;i++){
            let data={
              value:res.data[i]['name'],
              discription:res.data[i]['business'],
              count: res.data[i]['count']
            }
            this.listdata.push(data)
          }
        })
      }

  }

</script>

<style lang="scss">
  #page-user-list {
    .user-list-filters {
      .vs__actions {
        position: absolute;
        right: 0;
        top: 50%;
        transform: translateY(-58%);
      }
    }
  }
</style>
