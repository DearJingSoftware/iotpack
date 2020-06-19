<template>
  <page-header-wrapper>
    <a-card :bordered="false">
      <a-row>
        <a-col :sm="6" :xs="24">
          <info title="网关总数" value="8" :bordered="true"/>
        </a-col>
        <a-col :sm="6" :xs="24">
          <info title="上行流量" value="800G" :bordered="true"/>
        </a-col>
        <a-col :sm="6" :xs="24">
          <info title="下行流量" value="200M" :bordered="true"/>
        </a-col>
        <a-col :sm="6" :xs="24">
          <info title="异常网关" value="3"/>
        </a-col>
      </a-row>
    </a-card>

    <a-card
      style="margin-top: 24px"
      :bordered="false"
      title="网关">
      <div class="operate">
        <a-button type="dashed" icon="plus" @click="add">创建设备网关</a-button>
      </div>

      <div slot="extra">
        <a-radio-group v-model="type">
          <a-radio-button value="all">全部</a-radio-button>
          <a-radio-button value="processing">烟感</a-radio-button>
          <a-radio-button value="waiting">燃气</a-radio-button>
          <a-radio-button value="waiting">手报</a-radio-button>
          <a-radio-button value="waiting">门磁</a-radio-button>
        </a-radio-group>
        <a-input-search style="margin-left: 16px; width: 272px;"/>
      </div>

      <a-list size="large" :pagination="{showSizeChanger: true, showQuickJumper: true, pageSize: 5, total: 50}">
        <a-list-item :key="index" v-for="(item, index) in data">
          <a-list-item-meta :description="item.description">
            <a-avatar slot="avatar" size="large" shape="square" :src="item.avatar"/>
            <a slot="title"> 网关名称: {{ item.title }}</a>
            <a slot="title"> 网关协议: {{ item.sn }}</a>
          </a-list-item-meta>
          <div slot="actions">
            <a @click="edit(item)">上传流量 80</a>
          </div>
          <div slot="actions">
            <a @click="edit(item)">下载流量 20</a>
          </div>
          <div slot="actions">
            <a @click="edit(item)">数量 54</a>
          </div>
          <div slot="actions">
            <a-dropdown>
              <a-menu slot="overlay">
                <a-menu-item><a>编辑</a></a-menu-item>
                <a-menu-item><a>增加设备</a></a-menu-item>
                <a-menu-item><a>删除</a></a-menu-item>
              </a-menu>
              <a>操作
                <a-icon type="down"/>
              </a>
            </a-dropdown>
          </div>
        </a-list-item>
      </a-list>
    </a-card>
  </page-header-wrapper>
</template>

<script>
  // 演示如何使用 this.$dialog 封装 modal 组件
  import TaskForm from './modules/TaskForm'
  import Info from './components/Info'

  const data = []
  data.push({
    title: 'NB',
    sn: 'mqtt',
    avatar: '/logo.png',
    description: '网关位置: 河南省郑州市财富',
    owner: '800',
    startAt: '2018-07-26 22:44',
    status: '在线'
  })

  data.push({
    title: 'WIFI',
    sn: 'mqtt',
    avatar: '/logo.png',
    description: '网关位置: 河南省郑州市财富广场',
    owner: '200',
    startAt: '2018-07-26 22:44',
    status: '离线'
  })

  data.push({
    title: 'IBEACON',
    sn: 'mqtt',
    avatar: '/logo.png',
    description: '网关位置: 河南省郑州市财富广场',
    owner: '200',
    startAt: '2018-07-26 22:44',
    status: '离线'
  })

  data.push({
    title: 'VideoGateway',
    sn: 'mqtt',
    avatar: '/logo.png',
    description: '网关位置: 河南省郑州市财富广场',
    owner: '200',
    startAt: '2018-07-26 22:44',
    status: '离线'
  })

  export default {
    name: 'ProductList',
    components: {
      TaskForm,
      Info
    },
    data () {
      return {
        query: {},
        data,
        status: 'all'
      }
    },
    methods: {
      list () {
        console.log('列表更新')
      },
      add () {
        this.$dialog(TaskForm,
          // component props
          {
            record: {},
            on: {
              ok () {
                console.log('ok 回调')
              },
              cancel () {
                console.log('cancel 回调')
              },
              close () {
                console.log('modal close 回调')
              }
            }
          },
          // modal props
          {
            title: '新增',
            width: 700,
            centered: true,
            maskClosable: false
          })
      },
      edit (record) {
        console.log('record', record)
        this.$dialog(TaskForm,
          // component props
          {
            record,
            on: {
              ok () {
                console.log('ok 回调')
              },
              cancel () {
                console.log('cancel 回调')
              },
              close () {
                console.log('modal close 回调')
              }
            }
          },
          // modal props
          {
            title: '操作',
            width: 700,
            centered: true,
            maskClosable: false
          })
      }
    }
  }
</script>

<style lang="less" scoped>
  .ant-avatar-lg {
    width: 48px;
    height: 48px;
    line-height: 48px;
  }

  .list-content-item {
    color: rgba(0, 0, 0, .45);
    display: inline-block;
    vertical-align: middle;
    font-size: 14px;
    margin-left: 40px;

    span {
      line-height: 20px;
    }

    p {
      margin-top: 4px;
      margin-bottom: 0;
      line-height: 22px;
    }
  }
</style>
