import pandas as pd
from sklearn.neighbors import KDTree
fname = "../csv/iris_large.csv"
data = pd.read_csv(fname, delimiter=' ', header=0)
print(data)
print('\nbuilding kd-tree...', end='')
kdt = KDTree(data.iloc[:,0:4], leaf_size=1, metric='euclidean')
print(' done')
#x = [1.1, 2.2, 3.3, 4.4]

x = [41.1, 32.2, 23.3, 14.4]
print('\n  my measurements [sepal_len, sepal_wid, petal_len, petal_wid] are: ', x)
dist, idx = kdt.query([x], k=1)
print(f'    -> the iris {x} is closest to type {data.iloc[idx[0, 0],4]}')

print(f'\t Index/indices of the {len(idx[0])} closest point(s): {idx[0]}')
print(f'\t Distance(s) to the {len(dist[0])} closest point(s): {dist[0]}')
c= idx[0]
print(c)
line=data.iloc[c]
print(data.iloc[c])
print('mean')
a=(line['sepal_len']+line['sepal_wid']+line['petal_len']+line['petal_wid'])/4
print(a)

