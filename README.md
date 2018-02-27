# 画王八
这是《Java就该这样学》里面的一道练习，用非常基础的几个类画一个乌龟，涉及：
1.Frame类（窗体）、Graphics类（画笔）、Panel类（画布）等；
2.重点是Graphics类，通过实践了解该类中画椭圆（drawOval）、多边形(drawPolygon)、圆弧（drawArc）等的用法，因为API有些地方写的不是很清楚，比如画圆弧
public abstract void drawArc​(int x,
                             int y,
                             int width,
                             int height,
                             int startAngle,
                             int arcAngle)
                             
Parameters:
    x - the x coordinate of the upper-left corner of the arc to be drawn.
    y - the y coordinate of the upper-left corner of the arc to be drawn.
    width - the width of the arc to be drawn.
    height - the height of the arc to be drawn.
    startAngle - the beginning angle.
    arcAngle - the angular extent of the arc, relative to the start angle.
See Also:
    fillArc(int, int, int, int, int, int)
中间还有一些解释，我的需求是把两个点连起来，中间有点弧度，对弧度的方向有要求，弧度大小要求不是很严格，这个方法需要先用前四个参数确定一个矩形，
矩形的中心就是圆弧的中心；然后确定角度，从中心点向正右方画一条直线，再从中心点到圆弧的起点画一条直线，两线夹角就是起始角度，也就是drawArc()
方法的第5个参数。
    需要注意角度的单位是度，且该方法要求参数为整数；通过反三角函数Math.atan()得到的角，单位是“弧度”。当然最后我没用这个算法，而是取了特殊角90°、45°
	
	另外一个重点是乌龟身上的花纹，需要在椭圆（乌龟身体）边框上找到6个合适的点，这6个点的坐标值都是整数。
	通过实验发现，坐标系固定、椭圆大小固定的情况下，椭圆上坐标为整数的点，个数也是固定的。
