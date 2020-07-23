<script>
	import LeftNav from '../components/LeftNav.svelte';
	import TopNav from '../components/TopNav.svelte';


	export let segment;
</script>

<style>
	.main_body{
		display: flex;
		flex-grow: 1;
		flex-direction: column;
	}
	main {
		background-color: white;
		margin: 24px;
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


<main>
	<slot></slot>
</main>
</div>