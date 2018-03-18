## MySQL的数据类型
|数据类型|字节|
|:------|:---|
|TINYINT|1字节|
|SMALLINT|2字节|
|MEDIUMINT|3字节|
|INT(INTEGER)|4字节|
|BIGINT|8字节|

PS:INT(11),代表能显示11位数字

## 浮点数类型和定点数类型
|类型名称|说明|字节|
|:------|----|---|
|FLOAT|单精度类型|4字节|
|DOUBLE|双精度类型|8字节|
|DECMIAL(M, D),DEC|压缩的"严格定数"|M + 2个字节|
PS:DECMIALF实际是以串存放的.