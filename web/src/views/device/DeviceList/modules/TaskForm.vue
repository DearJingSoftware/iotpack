<template>
  <a-form @submit="handleSubmit" :form="form">
    <a-form-item
      label="设备唯一标识"
      :labelCol="labelCol"
      :wrapperCol="wrapperCol"
    >
      <a-input v-decorator="['uuid', {rules:[{required: true, message: '设备唯一标识'}]}]"/>
    </a-form-item>
    <a-form-item
      label="产品类型"
      :labelCol="labelCol"
      :wrapperCol="wrapperCol"
    >
      <a-select v-decorator="['owner', {rules:[{required: true, message: '请选择开始时间'}]}]">
        <a-select-option :value="0">付晓晓</a-select-option>
        <a-select-option :value="1">周毛毛</a-select-option>
      </a-select>
    </a-form-item>
    <a-form-item
      label="接入网关"
      :labelCol="labelCol"
      :wrapperCol="wrapperCol"
    >
      <a-select v-decorator="['owner', {rules:[{required: true, message: '请选择开始时间'}]}]">
        <a-select-option :value="0">付晓晓</a-select-option>
        <a-select-option :value="1">周毛毛</a-select-option>
      </a-select>
    </a-form-item>
    <a-form-item
      label="设备位置"
      :labelCol="labelCol"
      :wrapperCol="wrapperCol"
    >
      <a-input v-decorator="['addr', {rules:[{ message: '设备位置'}]}]"/>
    </a-form-item>

  </a-form>
</template>

<script>
  import pick from 'lodash.pick'

  const fields = ['title', 'startAt', 'owner', 'description']

  export default {
    name: 'TaskForm',
    props: {
      record: {
        type: Object,
        default: null
      }
    },
    data () {
      return {
        labelCol: {
          xs: { span: 24 },
          sm: { span: 7 }
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 13 }
        },
        form: this.$form.createForm(this)
      }
    },
    mounted () {
      this.record && this.form.setFieldsValue(pick(this.record, fields))
    },
    methods: {
      onOk () {
        console.log('监听了 modal ok 事件')
        return new Promise(resolve => {
          resolve(true)
        })
      },
      onCancel () {
        console.log('监听了 modal cancel 事件')
        return new Promise(resolve => {
          resolve(true)
        })
      },
      handleSubmit () {
        const { form: { validateFields } } = this
        this.visible = true
        validateFields((errors, values) => {
          if (!errors) {
            console.log('values', values)
          }
        })
      }
    }
  }
</script>
