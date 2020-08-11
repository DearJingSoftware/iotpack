
<svelte:head>
	<title>用户注册</title>
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
.option {
	margin:10px 0px;
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
		<div class="application_name">IotPack 最简单的iot设备管理工具</div>
	</div>
	<UIForm>
		<UIFormGroup title="账户:">
				<UITextInput  placeholder="邮箱或者电话号码"></UITextInput>
		</UIFormGroup>
		<UIFormGroup title="密码:">
				<UITextPassword placeholder="密码" disabled></UITextPassword>
		</UIFormGroup>
		<UIFormGroup title="确认密码:">
				<UITextPassword placeholder="确认密码" disabled></UITextPassword>
		</UIFormGroup>
	<div class="option">
		<LayoutAlignBoth style="margin:0px 10px;">
			<UiCheckBox href="agreement">我同意许可协议</UiCheckBox>
		</LayoutAlignBoth>
	</div>	
		<UIButton>注册</UIButton>
		<div class="option">
			<LayoutAlignBoth style="margin:0px 10px;">
				<UILink href="/auth/login">已经有账户?去登录</UILink>
			</LayoutAlignBoth>
		</div>
	</UIForm>
</form>

