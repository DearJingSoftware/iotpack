
import { writable } from 'svelte/store';




var authData={
  user:{
    username:""
  }
};
if (window && window.localStorage){
  // authData=localStorage.setItem('auth',JSON(JSON.stringify()));
}
 

function authStore() {
	const { subscribe, set, update } = writable(authData);

	return {
    subscribe,
    setAuth:(n1)=>update(n=>{
      return n1;
    }),
    clearAuth:()=>set({})
	};
}

export default authStore();