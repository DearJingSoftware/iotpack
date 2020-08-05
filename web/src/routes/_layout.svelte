<script>
	import LeftNav from '../components/LeftNav.svelte';
	import TopNav from '../components/TopNav.svelte';
	import FastNav from '../components/FastNav.svelte';

	import auth from "../config/auth.js"

	export let segment;

	import { onMount } from 'svelte';

	onMount(() => {
		// auth.setAuth()
		// var authData=localStorage.setItem('auth',JSON(JSON.stringify()));
		console.log("页面加载完成")
	});
</script>

<style>
	.main_body{
		display: flex;
		flex-grow: 1;
		flex-direction: column;
		overflow-y: auto;
	}
	main {
		background-color: white;
		/* padding: 20px; */
		flex-grow: 1;
		box-sizing: border-box;
		display: flex;
		border-radius: 4px;
    flex-direction: column;
	}
</style>
{#if segment!="auth"}
	<LeftNav {segment}/>
{/if}
<div class="main_body">
{#if segment!="auth"}
	<TopNav {segment}/>
{/if}
<!-- <FastNav {segment}/> -->

<main>
	<slot></slot>
</main>
</div>