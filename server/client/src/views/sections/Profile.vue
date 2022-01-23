<template>
  <section class="section-container">
    <sf-content-pages
      title="My Account"
      :active="activePage"
      class="my-account"
      @click:change="changeActivePage"
    >
      <sf-content-category title="Personal Details">
        <sf-content-page
            title="My profile"
            data-testid="my-profile"
        >
          <sf-my-profile
            :account="account"
            data-testid="my-profile-tabs"
            @update:personal="account= { ...account, ...$event },updateAccount(account)"
            @update:password="account = { ...account, ...$event },updatePassword(account)"
          />
        </sf-content-page>
        <sf-content-page title="나의 피부타입 설문 결과">
         <sf-order-history :orders="account.orders" />
        </sf-content-page>
        <sf-content-page title="유전자 검사 결과">
            <error></error>
        </sf-content-page>
      </sf-content-category>
    </sf-content-pages>
  </section>
</template>

<script>
  import {
    SfContentPages,
    SfMyProfile,
    SfOrderHistory,
  } from '@storefront-ui/vue'
  import Error from '@storefront-ui/vue/src/components/pages/error/Error.vue'

  export default {
    name: 'Profile',
    components: {
      SfContentPages,
      SfMyProfile,
      Error,
      SfOrderHistory,
    },
    data () {
      return {
        activePage: 'My profile',
        account: {
          id: '',
          name: '',
          email: '',
          password: '',
          shipping: [
            {
              name: 'John',
              streetName: 'Sezame Street',
              apartment: '24/193A',
              city: 'Wroclaw',
              state: 'Lower Silesia',
              zipCode: '53-540',
              country: 'Poland',
              phoneNumber: '(00)560 123 456',
            },
            {
              name: 'John',
              streetName: 'Sezame Street',
              apartment: '20/193A',
              city: 'Wroclaw',
              state: 'Lower Silesia',
              zipCode: '53-603',
              country: 'Poland',
              phoneNumber: '(00)560 123 456',
            },
          ],
          orders: [
            ['#45', '23th June, 2021', 'Visa card', '$412.00', 'Finalised'],
            ['#46', '26th June, 2021', 'Paypal', '$132.00', 'Finalised'],
            ['#47', '28th June, 2021', 'Mastercard', '$12.00', 'Finalised'],
            ['#48', '28th June, 2021', 'Paypal', '$20.00', 'In process'],
          ],
        },
      }
    },
    computed: {
      currentUser () {
        return this.$store.state.auth.user
      },
    },
    mounted () {
      if (!this.currentUser) {
        this.$router.push('/login')
      }
    },
    created () {
      this.account.id = this.currentUser.id
      this.account.name = this.currentUser.username
      this.account.email = this.currentUser.email
    },
    methods: {
      changeActivePage (title) {
        this.activePage = title
      },
      updateAccount (data) {
        alert('준비중입니다')
      },
      updatePassword () {
        alert('준비중입니다')
      },
    },
  }
</script>
<style lang="scss" scoped>
@import "~@storefront-ui/vue/styles";
#my-account {
  box-sizing: border-box;
  @include for-desktop {
    max-width: 100%;
    padding: 0 var(--spacer-sm);
    margin: 0 auto;
  }
}
.my-account {
  @include for-mobile {
    --content-pages-sidebar-category-title-font-weight: var(
      --font-weight--normal
    );
    --content-pages-sidebar-category-title-margin: var(--spacer-sm)
      var(--spacer-sm) var(--spacer-sm) var(--spacer-base);
  }
  @include for-desktop {
    --content-pages-sidebar-category-title-margin: var(--spacer-xl) 0 0 0;
  }
}
</style>
