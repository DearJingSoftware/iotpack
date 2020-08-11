
<svelte:head>
	<title>忘记密码</title>
</svelte:head>

<script>
	import UIForm from '../../uikit/form/UIForm.svelte';
	import UIFormGroup from '../../uikit/form/UIFormGroup.svelte';
	import UITextInput from '../../uikit/form/UITextInput.svelte';
	import UITextPassword from '../../uikit/form/UITextPassword.svelte';
	import UIButton from '../../uikit/form/UIButton.svelte';
	import UILink from '../../uikit/form/UILink.svelte';

	import UiCheckBox from '../../uikit/form/UICheckBox.svelte';
	import LayoutAlignBoth from '../../uikit/layout/LayoutAlignBoth.svelte';
</script>

<style>
.login_form {
	margin: 0 auto;
	width: 20vw;
}
.logo {
	margin-top: 150px;
	margin-bottom: 50px;
	display: flex;
	flex-direction: column;
  justify-content: center;
  justify-items: center;
 	align-items: center;
}

</style>


<form class="login_form">
	<div class="logo">
		<img class="application_logo" src="/logo.png" alt="logo" width="64px" height="64px"/>
		<div class="application_name">IotPack</div>
	</div>
	<UIForm>
		<UIFormGroup title="账户:">
				<UITextInput  placeholder="邮箱或者电话号码"></UITextInput>
		</UIFormGroup>
	
		<UIButton>确认</UIButton>
		
	</UIForm>
</form>

