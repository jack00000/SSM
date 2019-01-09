package com.whgc.test.osjl;
public class EuclideanMetric {
 
	/**
	 * 两个向量可以为任意维度，但必须保持维度相同，表示n维度中的两点
	 * 
	 * @param vector1
	 * @param vector2
	 * @return 两点间距离
	 */
	public double sim_distance(double[] vector1, double[] vector2) {
		double distance = 0;
		
		if (vector1.length == vector2.length) {
			for (int i = 0; i < vector1.length; i++) {
				double temp = Math.pow((vector1[i] - vector2[i]), 2);
				distance += temp;
			}
			distance = Math.sqrt(distance);
		}
		return distance;
	}
 
}
