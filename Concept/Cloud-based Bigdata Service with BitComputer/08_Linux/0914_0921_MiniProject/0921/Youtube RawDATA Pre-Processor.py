#!/usr/bin/env python
# coding: utf-8

# In[1]:


import time
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
import json
from datetime import timedelta
from IPython.display import display

pd.options.display.float_format = "{:.2f}".format #pandas 출력 포맷팅 참고(https://financedata.github.io/posts/pandas-display-format.html)

get_ipython().run_line_magic('matplotlib', 'inline')


# In[2]:


filedate = 18
tglr = -1
compareparam = 1

meridiemparam = {-1:"A", 1:"P"}
datanames = ["data0"]
dfnames = ["df0"]
filenames = ["20.{}.09_KR_videos_{}M".format(str(filedate), meridiemparam[tglr])]
colorparam = ["b","g","r","c","m","y","k"]

if compareparam != 1:
    for i in range(compareparam-1):
        datanames.append("data"+str(i+1))
        dfnames.append("data"+str(i+1))

        tglr *= -1
        if tglr != 1 : filedate += 1
        filenames.append("20.{}.09_KR_videos_{}M".format(str(filedate), meridiemparam[tglr]))
        
    for i in range(compareparam):
        globals()[datanames[i]] = pd.read_csv("D:/ovm/vboxshare/Project/Raw-Data/{}.csv".format(filenames[i]), engine = "python", encoding="utf-8")
        print("{}\n".format(filenames[i]))

else : globals()[datanames[0]] = pd.read_csv("D:/ovm/vboxshare/Project/Raw-Data/{}.csv".format(filenames[0]), engine = "python", encoding="utf-8")


# In[3]:


# data = pd.read_csv("D:/ovm/vboxshare/Project/Raw-Data/{}.csv".format(filename), engine = "python", encoding="utf-8")


# In[4]:


for i in range(compareparam) : print("{}.csv\n{}\n".format(filenames[i], globals()[datanames[i]].info()))


# In[5]:


for i in range(compareparam):
    globals()[dfnames[i]] = globals()[datanames[i]]
    for col in ["thumbnail_link", "comments_disabled", "ratings_disabled"]:
        del globals()[dfnames[i]][col]


# In[6]:


for i in range(compareparam):    
    print("{}\n".format(globals()[dfnames[i]]["video_id"].duplicated().value_counts()))
    globals()[dfnames[i]] = globals()[dfnames[i]].drop_duplicates(["video_id"])[:]


# In[7]:


catdata = pd.read_csv("D:/ovm/vboxshare/Project/Raw-Data/category.csv", engine="python")


# In[8]:


catdata.info()


# In[9]:


for i in range(compareparam): 
    globals()[dfnames[i]] = globals()[dfnames[i]].merge(catdata, how='left', on='categoryId')
    print("{}\n".format(globals()[dfnames[i]].isnull().sum()))


# In[10]:


for i in range(compareparam): 
    globals()[datanames[i]]["trending_date"] = pd.to_datetime(globals()[datanames[i]]["trending_date"], format = "%y.%d.%m")
    globals()[dfnames[i]]["trending_date"] = pd.to_datetime(globals()[dfnames[i]]["trending_date"], format = "%y.%d.%m")
    globals()[dfnames[i]]["publishedAt"] = pd.to_datetime(globals()[dfnames[i]]["publishedAt"])
    globals()[dfnames[i]]["publishedAt"] = globals()[dfnames[i]]["publishedAt"].apply(lambda x : x.date())
    globals()[dfnames[i]]["publishedAt"] = pd.to_datetime(globals()[dfnames[i]]["publishedAt"])
    
    globals()[dfnames[i]]["tag_count"] = globals()[dfnames[i]]["tags"].apply(lambda x : len(x.split("|")) if x != "[none]" else 0)
    
    globals()[dfnames[i]]["likes/view_count"] = globals()[dfnames[i]]["likes"] / globals()[dfnames[i]]["view_count"]
    globals()[dfnames[i]]["dislikes/view_count"] = globals()[dfnames[i]]["dislikes"] / globals()[dfnames[i]]["view_count"]
    globals()[dfnames[i]]["comment_count/view_count"] = globals()[dfnames[i]]["comment_count"] / globals()[dfnames[i]]["view_count"]
    globals()[dfnames[i]]["tag_count/view_count"] = globals()[dfnames[i]]["tag_count"] / globals()[dfnames[i]]["view_count"]
    
    globals()[dfnames[i]]["dislikes/likes"] = globals()[dfnames[i]]["dislikes"] / globals()[dfnames[i]]["likes"]
    globals()[dfnames[i]]["likes/dislikes"] = globals()[dfnames[i]]["likes"] / globals()[dfnames[i]]["dislikes"]
    globals()[dfnames[i]]["dislikes/likes"].loc[globals()[dfnames[i]]["dislikes/likes"] == np.inf] = 0
    globals()[dfnames[i]]["likes/dislikes"].loc[globals()[dfnames[i]]["likes/dislikes"] == np.inf] = 0
    globals()[dfnames[i]]["dislikes/likes"].loc[globals()[dfnames[i]]["dislikes/likes"].isnull() == True] = 0
    globals()[dfnames[i]]["likes/dislikes"].loc[globals()[dfnames[i]]["likes/dislikes"].isnull() == True] = 0
        
    print("{}\n".format(globals()[dfnames[i]].isnull().sum()))
    globals()[dfnames[i]].to_csv("D:/ovm/vboxshare/Project/CSVs/{}_PrP.csv".format(filenames[i]), encoding="utf-8")


# In[11]:


for i in range(compareparam):
    globals()[dfnames[i]]["title_length"] = globals()[dfnames[i]]["title"].apply(lambda x : len(str(x)) if pd.isnull(x) == False  else 0)
    globals()[dfnames[i]]["Pub-to-Trend_Time"] = globals()[dfnames[i]]["trending_date"] - globals()[dfnames[i]]["publishedAt"] + timedelta(days = 1)
    print("{}\n".format(globals()[dfnames[i]].info()))
    
    globals()[dfnames[i]].to_excel("D:/ovm/vboxshare/Project/XLSXs/{}.xlsx".format(filenames[i]), encoding="utf-8")


# In[12]:


for i in range(compareparam):print("'{}' 파일의 분석에 사용한 데이터는 {}개의 변수를 가진 인기동영상 데이터 {}개입니다.".format(filenames[i], len(globals()[dfnames[i]].columns), format(len(globals()[dfnames[i]]),",")))


# In[13]:


for i in range(compareparam):
    globals()[dfnames[i]].describe()


# In[14]:


for n in range(compareparam):
    plt.figure(figsize = (25, 25))
    print("{}\n".format(filenames[n]))
    for i in range(len(globals()[dfnames[n]].describe().columns) - 1):
        plt.subplot(4, 4, i + 1)
        plt.title(globals()[dfnames[n]].describe().columns[i])
        plt.hist(globals()[dfnames[n]][globals()[dfnames[n]].describe().columns[i]],bins=10,color=colorparam[(n+1)%len(colorparam)-1])
        plt.grid()
    plt.savefig("D:/ovm/vboxshare/Project/PNGs/Raw_Histogram/{}.png".format(filenames[n]))
        
# 수치형 변수의 분포 그래프. Raw-DATA 기반의 정보로 전처리 전의 원시값이다.


# In[15]:


for i in range(compareparam):
    display(filenames[i])
    display(pd.DataFrame(globals()[dfnames[i]][["video_id", "title", "channelTitle", "category", "view_count", "likes", "dislikes", "comment_count", "Pub-to-Trend_Time"]].sort_values(by = ["view_count"], ascending = [False]).head(5)))


# In[16]:


for i in range(compareparam):
    print(filenames[i])
    print("전체 데이터 {}건".format(len(globals()[dfnames[i]])))
    print("1000만이상 {}건 전체의 {:.2f}%".format(len(globals()[dfnames[i]].loc[globals()[dfnames[i]]["view_count"] >= 10000000]),len(globals()[dfnames[i]].loc[globals()[dfnames[i]]["view_count"] >= 10000000]) / len(globals()[dfnames[i]]) * 100))
    print("100만이상 {}건 전체의 {:.2f}%".format(len(globals()[dfnames[i]].loc[globals()[dfnames[i]]["view_count"] >= 1000000]),len(globals()[dfnames[i]].loc[globals()[dfnames[i]]["view_count"] >= 1000000]) / len(globals()[dfnames[i]]) * 100))
    print("100만이하 {}건 전체의 {:.2f}%\n".format(len(globals()[dfnames[i]].loc[globals()[dfnames[i]]["view_count"] < 1000000]),len(globals()[dfnames[i]].loc[globals()[dfnames[i]]["view_count"] < 1000000]) / len(globals()[dfnames[i]]) * 100))


# In[17]:


plt.figure(figsize=(20,compareparam*(15//compareparam+1)))
for i in range(compareparam):
    plt.subplot(compareparam//2+1,compareparam//2+1,i+1)
    plt.title("Mean : {:.2f}".format(globals()[dfnames[i]]["view_count"].loc[globals()[dfnames[i]]["view_count"] <= 1000000].mean()))
    plt.hist(globals()[dfnames[i]]["view_count"].loc[globals()[dfnames[i]]["view_count"] <= 1000000], color=colorparam[(i+1)%len(colorparam)-1]);

plt.savefig("D:/ovm/vboxshare/Project/PNGs/Raw_Histogram/[{}]_TO_[{}]_ViewCountUnderMillion.png".format(filenames[0], filenames[compareparam-1]))

# 조회수 일백만 미만의 값들만 추려낸(=독보적인 조회수의 몇몇 이상치를 제외한)후, 조회수에 대해서만 다시 추이 그래프를 평균값과 출력.


# In[18]:


# df.loc[df["view_count"] <= 22000,["video_id", "title", "publishedAt", "trending_date", "category", "view_count", "likes", "comment_count", "tag_count"]].sort_values(by = "view_count")


# In[19]:


for i in range(compareparam): globals()[dfnames[i]].to_csv("D:/ovm/vboxshare/Project/CSVs/{}_PrP.csv".format(filenames[i]), encoding="utf-8")


# In[20]:


# df[["video_id", "title", "channelTitle", "category", "view_count", "likes", "dislikes", "comment_count", "tag_count"]].sort_values(by = ["likes"], ascending = [False]).head(3)


# In[21]:


# df[["video_id", "title", "channelTitle", "category", "view_count", "likes", "dislikes", "comment_count", "tag_count"]].sort_values(by = ["dislikes"], ascending = [False]).head(3)


# In[22]:


# df[["video_id", "title", "channelTitle", "category","view_count","likes", "dislikes", "comment_count", "tag_count"]].sort_values(by = ["comment_count"], ascending = [False]).head(3)


# In[23]:


plt.figure(figsize=(20,compareparam*(15//compareparam+1)))
for i in range(compareparam):
    plt.subplot(compareparam//2+1,compareparam//2+1,i+1)
    plt.title("'tag_count' of [{}]".format(filenames[i]))
    plt.hist(globals()[dfnames[i]]["tag_count"],bins = 10,color=colorparam[(i+1)%len(colorparam)-1]);
    
plt.savefig("D:/ovm/vboxshare/Project/PNGs/Tag_Count/[{}]_TO_[{}].png".format(filenames[0], filenames[compareparam-1]))

# 각 단위시간에 해당하는 파일 별, 'TAG 수'에 대한 추이 그래프.


# In[24]:


plt.figure(figsize=(20,compareparam*(15//compareparam+1)))
for i in range(compareparam):
    plt.subplot(compareparam//2+1,compareparam//2+1,i+1)
    plt.title("likes/dislikes of [{}]".format(filenames[i]))
    plt.hist(globals()[dfnames[i]]["likes/dislikes"].loc[globals()[dfnames[i]]["likes/dislikes"] <= 200],bins = 250,color=colorparam[(i+1)%len(colorparam)-1]);
    
plt.savefig("D:/ovm/vboxshare/Project/PNGs/LikeDivDislike/[{}]_TO_[{}].png".format(filenames[0], filenames[compareparam-1]))

# 각 단위시간에 해당하는 파일 별, 'likes/dislikes'에 대한 추이 그래프.


# In[25]:


for i in range(compareparam):
    print(filenames[i])
    display(globals()[dfnames[i]][["video_id", "title", "channelTitle", "category", "view_count", "likes", "dislikes", "comment_count", "tag_count"]].sort_values(by = ["view_count"], ascending = [False]).head(10))

# TAG 수 기준으로 상위 10위 내림차순 정렬한 Table(=Tag 수 기준 Top 10)


# In[26]:


for i in range(compareparam):
    print(filenames[i])
    display(globals()[dfnames[i]][["video_id", "title", "channelTitle", "category", "view_count", "likes/dislikes"]].sort_values(by = ["view_count"], ascending = [False]).head(10))


# In[27]:


#for i in range(compareparam):
#    print(filenames[i])
#    display(globals()[dfnames[i]][["likes/view_count", "dislikes/view_count", "comment_count/view_count", "dislikes/likes"]].describe())


# In[28]:


# df[["video_id", "title", "channelTitle", "category", "view_count", "likes/view_count", "dislikes/view_count", "comment_count/view_count", "dislikes/likes", "trending_date"]].sort_values(by = ["likes/view_count"], ascending = [False]).head(5)


# In[29]:


# df[["video_id", "title", "channelTitle", "category", "view_count", "likes/view_count", "dislikes/view_count", "comment_count/view_count", "dislikes/likes", "trending_date"]].sort_values(by = ["dislikes/view_count"], ascending = [False]).head(5)


# In[30]:


# df[["video_id", "title", "channelTitle", "category", "view_count", "likes", "dislikes", "dislikes/likes", "trending_date"]].sort_values(by = ["dislikes/likes"], ascending = [False]).head(5)


# In[31]:


plt.figure(figsize=(20,compareparam*(15//compareparam+1)))
for i in range(compareparam):
    plt.subplot(compareparam//2+1,compareparam//2+1,i+1)
    plt.title(filenames[i])
    plt.hist(globals()[dfnames[i]]["title_length"],bins = 10,color=colorparam[(i+1)%len(colorparam)-1])
    plt.axvline(x = 42, color = "w", linestyle = "-", linewidth = 1)
    
plt.savefig("D:/ovm/vboxshare/Project/PNGs/Title_Length/[{}]_TO_[{}].png".format(filenames[0], filenames[compareparam-1]))


# In[32]:


for i in range(compareparam):
    print(filenames[i])
    display(globals()[dfnames[i]].loc[globals()[dfnames[i]]["title_length"] <= 2])


# In[33]:


for i in range(compareparam):
    print(filenames[i])
    print(globals()[dfnames[i]]["Pub-to-Trend_Time"].describe())
    print()
    
# 해당 단위시간대에 올라와 있는 인기 영상들이, 각각 처음 게시된 이후로부터 지난 시간이 얼마나 되는가.
# (= 현 시점에 인기 영상 목록에 진입해있는 영상들이 인기 목록에 오른 후 얼마나 오랫동안 생존해 온 것인가.)


# In[34]:


for i in range(compareparam):
    print(filenames[i])
    print(pd.cut(globals()[dfnames[i]]["Pub-to-Trend_Time"],[timedelta(days = 0),timedelta(days = 1),timedelta(days = 2),timedelta(days = 3),timedelta(days = 10)]).value_counts(sort = False,normalize = True))
    print()


# In[35]:


for n in range(compareparam):
    print("{}\n[{}]\n\n전체 데이터 {}개\ncategory 개수 {}개\n".format("-"*50,filenames[n],len(globals()[dfnames[n]]),len(globals()[dfnames[n]]["category"].unique())))
    for i in range(len(globals()[dfnames[n]]["category"].value_counts())):
        print("{:23} {:4} {:.2f}".format(globals()[dfnames[n]]["category"].value_counts().index[i],
                                globals()[dfnames[n]]["category"].value_counts().values[i],
                                globals()[dfnames[n]]["category"].value_counts(normalize = True).values[i]))
    print()
# category 별 인기동영상의 개수를 확인해본 결과.


# In[36]:


plt.figure(figsize=(20,8))
for i in range(compareparam):
    col = []
    val = []
    for n in range(5):
        col.append(globals()[dfnames[i]]["category"].value_counts().index[n])
        val.append(globals()[dfnames[i]]["category"].value_counts().values[n])
    plt.subplot(1,3,i+1)
    plt.title(filenames[i])
    plt.bar(col, val, color=colorparam[(i+1)%len(colorparam)-1])
    plt.xticks(rotation=90)
    plt.tight_layout()

plt.savefig("D:/ovm/vboxshare/Project/PNGs/Category_Count/[{}]_TO_[{}].png".format(filenames[0], filenames[compareparam-1]))


# In[37]:


for i in range(compareparam):
    print("[{}]".format(filenames[i]))
    for cate in globals()[dfnames[i]]["category"].value_counts().index[0:3]:
        print(cate, globals()[dfnames[i]]["Pub-to-Trend_Time"].loc[globals()[dfnames[i]]["category"] == cate].mean())
    print()

# 상위 3개 카테고리 영상의 평균 인기 영상 진입까지의 경과 일수.


# In[38]:


for i in range(compareparam): print("'{}' 파일의 전체 데이터 개수 {} 포함된 채널의 수 {}".format(filenames[i],len(globals()[dfnames[i]]), len(globals()[dfnames[i]]["channelTitle"].unique())))  


# In[39]:


for i in range(compareparam):
    plt.subplot(compareparam//2+1,compareparam//2+1,i+1)
    df_pivot=pd.pivot_table(globals()[dfnames[i]], index = ["channelTitle"], 
                        values = ["view_count"],
                        aggfunc = ["count", "mean"])
    df_pivot["count"]["view_count"].value_counts().plot(kind = "pie",title = "Trending Vid(s) per Channel of\n{}".format(filenames[i]),label = " ",figsize = (15, compareparam*(15//compareparam)));

plt.savefig("D:/ovm/vboxshare/Project/PNGs/VidsPerChannel/[{}]_TO_[{}].png".format(filenames[0], filenames[compareparam-1]))
    
# 해당 기간 동안 인기동영상 개수 별 채널의 수


# In[40]:


print("인기동영상 개수가 1개인 채널의 카테고리 현황.\n")
for i in range(compareparam):
    print("[{}]".format(filenames[i]))
    print(globals()[dfnames[i]]["category"].loc[globals()[dfnames[i]]["channelTitle"].isin(df_pivot[df_pivot["count"]["view_count"] == 1].index)].value_counts())
    print()
    
# 인기동영상 개수가 1개인 채널의 카테고리 현황.


# In[41]:


print("인기동영상 개수가 2~3개인 채널의 카테고리 현황.\n")
for i in range(compareparam):
    print("[{}]".format(filenames[i]))
    print(globals()[dfnames[i]]["category"].loc[globals()[dfnames[i]]["channelTitle"].isin(df_pivot[(df_pivot["count"]["view_count"] >= 2) & (df_pivot["count"]["view_count"] < 4)].index)].value_counts())
    print()

# 인기동영상 개수가 2~3개인 채널의 카테고리 현황.


# In[42]:


print("인기동영상 개수가 4개 이상인 채널의 카테고리 현황.\n")
for i in range(compareparam):
    print("[{}]".format(filenames[i]))
    print(globals()[dfnames[i]]["category"].loc[globals()[dfnames[i]]["channelTitle"].isin(df_pivot[df_pivot["count"]["view_count"] >= 4].index)].value_counts())
    print()
# 인기동영상 개수가 4개 이상인 채널의 카테고리 현황.


# In[43]:


for n in range(compareparam):
    plt.figure(figsize = (30, 30))
    for i in range(1,len(globals()[dfnames[n]].describe().columns) - 1):
        plt.subplot(4, 4, i)
        plt.title("view_count vs {}".format(globals()[dfnames[n]].describe().columns[i]))
        plt.xlabel("view_count")
        plt.ylabel(globals()[dfnames[n]].describe().columns[i])
        plt.scatter(x = globals()[dfnames[n]]["view_count"], y = globals()[dfnames[n]][globals()[dfnames[n]].describe().columns[i]],color=colorparam[(n+1)%len(colorparam)-1])
        plt.grid()
    plt.savefig("D:/ovm/vboxshare/Project/PNGs/Scatter/{}.png".format(filenames[n]))
    
# 조회수에 영향을 주는 항목들이 무엇인지 알아보기 위한 산점도.


# In[69]:


rdata = pd.read_csv('D:/ovm/vboxshare/Project/CSVs/20.18.09_KR_videos_AM_PrP.csv', index_col='video_id')
data0 = rdata[rdata['view_count'] <= 1000000]

# data0["view_count"] = (data0["view_count"] - data0["view_count"].min()) / (data0["view_count"].max() - data0["view_count"])

data0["tag_count"] = data0["tags"].apply(lambda x : len(x.split("|")) if x != "[none]" else 0)
data0 = data0[data0['dislikes'] < 2000]
data0 = data0[data0['likes'] < 25000]
data0 = data0[data0['comment_count'] < 5500]
data0 = data0[data0['tag_count'] < 80]
data0["dislikes/likes"] = data0["dislikes"] / data0["likes"]
data0 = data0[data0["dislikes/likes"] < 0.2]

data0["dislikes"] = (data0["dislikes"] - data0["dislikes"].min()) / (data0["dislikes"].max() - data0["dislikes"].min())
data0["likes"] = (data0["likes"] - data0["likes"].min()) / (data0["likes"].max() - data0["likes"].min())
data0["dislikes/likes"] = (data0["dislikes/likes"] - data0["dislikes/likes"].min()) / (data0["dislikes/likes"].max() - data0["dislikes/likes"].min())
data0["comment_count"] = (data0["comment_count"] - data0["comment_count"].min()) / (data0["comment_count"].max() - data0["comment_count"].min())
data0["tag_count"] = (data0["tag_count"] - data0["tag_count"].min()) / (data0["tag_count"].max() - data0["tag_count"].min())

sns.lmplot(data = data0, x='view_count', y='dislikes', palette="muted")
sns.lmplot(data = data0, x='view_count', y='likes', palette="muted")
sns.lmplot(data = data0, x='view_count', y='dislikes/likes', palette="muted")
sns.lmplot(data = data0, x='view_count', y='comment_count', palette="muted")
sns.lmplot(data = data0, x='view_count', y='tag_count', palette="muted")


# In[45]:


for i in range(compareparam):
    plt.figure(figsize = (20,20))
    sns_plt = sns.heatmap(data = globals()[dfnames[i]].loc[globals()[dfnames[i]]["view_count"] <= 1000000].corr(method="pearson"), annot = True, fmt = ".2f", linewidths = .5, cmap = "Blues");
    sns_plt.figure.savefig("D:/ovm/vboxshare/Project/PNGs/Heatmap/{}.png".format(filenames[i]))

# 조회수 상위 데이터를 제외한 상관관계.

