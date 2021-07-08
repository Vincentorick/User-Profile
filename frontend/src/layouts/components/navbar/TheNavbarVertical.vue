<!-- =========================================================================================
  File Name: TheNavbar.vue
  Description: Navbar component
  Component Name: TheNavbar
  ----------------------------------------------------------------------------------------
  Item Name: Vuexy - Vuejs, HTML & Laravel Admin Dashboard Template
  Author: Pixinvent
  Author URL: http://www.themeforest.net/user/pixinvent
========================================================================================== -->


<template>
  <div class="relative">

    <div class="vx-navbar-wrapper" :class="classObj">

      <vs-navbar class="vx-navbar navbar-custom navbar-skelton" :color="navbarColorLocal" :class="textColor">

        <!-- SM - OPEN SIDEBAR BUTTON -->
        <feather-icon class="sm:inline-flex xl:hidden cursor-pointer p-2" icon="MenuIcon" @click.stop="showSidebar" />

        <transition :name="routerTransition">

          <div v-if="$route.meta.breadcrumb || $route.meta.pageTitle" class="router-header flex flex-wrap items-center mb-6">
            <div
              class="content-area__heading"
              :class="{'pr-4 border-0 md:border-r border-solid border-grey-light' : $route.meta.breadcrumb}">
              <h2 class="mb-1">{{ routeTitle }}</h2>
            </div>

            <!-- BREADCRUMB -->
            <vx-breadcrumb class="ml-4 md:block hidden" v-if="$route.meta.breadcrumb" :route="$route" :isRTL="$vs.rtl" />

          </div>
        </transition>

        <vs-spacer />

        <search-bar />

<!--        <notification-drop-down />-->

        <profile-drop-down />

      </vs-navbar>
    </div>
  </div>
</template>


<script>
// import moduleUserManagement from '@/store/user-management/moduleUserManagement.js'
// import Bookmarks            from "./components/Bookmarks.vue"
import SearchBar            from "./components/SearchBar.vue"
// import NotificationDropDown from "./components/NotificationDropDown.vue"
import ProfileDropDown      from "./components/ProfileDropDown.vue"
import themeConfig         from '@/../themeConfig.js'

export default {
  name: "the-navbar-vertical",
  props: {
    navbarColor: {
      type: String,
      default: "#fff",
    },
  },
  components: {
    // Bookmarks,
    SearchBar,
    // NotificationDropDown,
    ProfileDropDown,
  },
  data(){
    return{
      routerTransition  : themeConfig.routerTransition || 'none',
      routeTitle        : this.$route.meta.pageTitle,
    }
  },
  watch:{
    "$route"() {
      this.routeTitle = this.$route.meta.pageTitle
    }
  },
  computed: {
    navbarColorLocal() {
      return this.$store.state.theme === "dark" && this.navbarColor === "#fff" ? "#10163a" : this.navbarColor
    },
    verticalNavMenuWidth() {
      return this.$store.state.verticalNavMenuWidth
    },
    textColor() {
      return {'text-white': (this.navbarColor != '#10163a' && this.$store.state.theme === 'dark') || (this.navbarColor != '#fff' && this.$store.state.theme !== 'dark')}
    },
    windowWidth() {
      return this.$store.state.windowWidth
    },

    // NAVBAR STYLE
    classObj() {
      if (this.verticalNavMenuWidth == "default")      return "navbar-default"
      else if (this.verticalNavMenuWidth == "reduced") return "navbar-reduced"
      else if (this.verticalNavMenuWidth)              return "navbar-full"
    },
  },
  methods: {
    showSidebar() {
      this.$store.commit('TOGGLE_IS_VERTICAL_NAV_MENU_ACTIVE', true);
    }
  }
}
</script>

