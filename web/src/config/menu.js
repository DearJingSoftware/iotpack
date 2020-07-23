import { writable } from 'svelte/store';


export const menu = writable([
  {
    segment:'dashboard',
    name:"首页",
    icon:'las la-tachometer-alt',
  },
  {
    segment:'project',
    name:"项目",
    icon:'las la-briefcase',
  },
  {
    segment:'organization',
    name:"组织",
    icon:'las la-user-friends',
  },
  {
    segment:'application',
    name:"应用",
    icon:'lab la-uikit',
  },
  {
    segment:'product',
    name:"产品",
    icon:'las la-mobile',
  },
  {
    segment:'device',
    name:"设备",
    icon:'lab la-connectdevelop',
  },
  {
    segment:'gateway',
    name:"网关",
    icon:'las la-sync',
  },
  {
    segment:'task',
    name:"任务",
    icon:'las la-tasks',
  },
  {
    segment:'calendar',
    name:"日历",
    icon:'las la-calendar',
  }
]);

