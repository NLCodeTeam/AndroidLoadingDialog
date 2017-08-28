# AndroidLoadingDialog
Simple custom dialog for android
![alt text](https://raw.githubusercontent.com/NLCodeTeam/AndroidLoadingDialog/master/Screenshot.png)

Use:
```Java
 LoadingDialog dialog = new LoadingDialog(this);
        dialog.setContentText("Waiting...");
        dialog.setCancelable(false);
        dialog.setBackPressed(false);
        dialog.show();
	```
