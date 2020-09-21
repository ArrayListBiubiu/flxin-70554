package ajax.json;


/**
 * src/main/webapp/javaweb.ajax/json.html
 *
 * <body>
 * <script>
 *     //---------------------------------------------------------{"":"","":"",...}是json格式
 *     var data = {
 *         "state" : 1,
 *         "message" : "登录成功"
 *     }
 *     alert(data.message)
 *     //---------------------------------------------------------属性的值可以是另一个json对象
 *     var user = {
 *         "name" : "葫芦娃",
 *         "department" : {
 *             "d_id" : 2,
 *             "d_name" : "开发部"
 *         }
 *     }
 *     alert(user.department.d_name)
 *     //---------------------------------------------------------属性的值可以是数组
 *     var u = {
 *         "address" : "南京",
 *         "skill" : ["java", "html", "xml", "mysql"]
 *     }
 *     alert(u.skill[2])
 *     for (var i = 0; i < u.skill.length; i++) {
 *         alert("循环输出：" + u.skill[i])
 *     }
 * </script>
 * </body>
 */
public class JsonHtml {
}
