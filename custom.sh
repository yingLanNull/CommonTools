echo "请输入IP地址: "
read input_variable
eeee="$input_variable"
read -p "点击Enter键继续"
echo "You entered: $eeee"
./gradlew assembleDebug -PVERSION_NAME_PARA=$eeee
