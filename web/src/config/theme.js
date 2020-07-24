import { writable } from 'svelte/store';

let defaultTheme = {
  //左侧菜单打开
  leftNavTaggle:false,
}

var customTheme=defaultTheme;

function themeStore() {
	const { subscribe, set, update } = writable(customTheme);

	return {
    subscribe,
    leftNavTaggle:()=>update(n=>{
      n.leftNavTaggle=!n.leftNavTaggle;
      return n;
    }),
    reset:()=>set(defaultTheme)
	};
}

export const theme = themeStore();