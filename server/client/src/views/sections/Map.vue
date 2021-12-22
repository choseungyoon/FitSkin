<template>
  <base-section
    id="map"
    space="0"
  >
    <iframe
      allowfullscreen
      aria-hidden="false"
      frameborder="0"
      height="500"
      src="https://maps.google.com/maps?q=%EC%9D%B8%EC%B2%9C%EA%B4%91%EC%97%AD%EC%8B%9C%20%EC%97%B0%EC%88%98%EA%B5%AC%20%ED%95%B4%EB%8F%8B%EC%9D%B4%EB%A1%9C%20107&t=&z=13&ie=UTF8&iwloc=&output=embed"
      style="border:0; display: block;"
      tabindex="0"
      width="100%"
    />
  </base-section>
</template>

<script>
  export default {
    name: 'SectionMap',

    provide: {
      heading: { align: 'center' },
    },
  }
</script>
