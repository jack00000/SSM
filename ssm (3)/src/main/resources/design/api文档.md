---
title: Pshare api文档
date: 2019-2-15 14:00
tags:
categories: 毕业设计
---


# 定义接口规范

## 1.http://localhost:8080/ssm/getPapersJson
- 获取首页的文章列表简略信息

```java
//失败
{
    "meta": {
        "status": 200,
        "msg": "getPapersJson failed"
    }
}
//成功
{
    "meta": {
        "status": 200,
        "msg": "success"
    },
    "response": {
        "has_more": true,
        "last_key": "1550186146_946656000",
        "feeds": [
            {
                "image":'url',
                "type": 1,
                "post": {
                    "id": 61246,
                    "genre": 1,
                    "title": "亚马逊准备赚更多广告费，奖励用户下载使用第三方应用",
                    "content": "",
                    "description": "亚马逊利用了其在商品目录与配送服务上的优势",
                    "publish_time": 1550213760,
                    "comment_count": 0,
                    "praise_count": 3,
                    "super_tag": "",
                    "page_style": 0,
                    "post_id": 64026,
                    "datatype": "article",
                    "category": {
                        "id": 18,
                        "title": "商业",
                        "image_black": "imgUrl",
                        "image_white": "imgUrl"
                    }
                }
            }
            ],
        "headline": {
            "image": "imgUrl",
            "type": 1,
            "post": {
                "id": 61232,
                "genre": 33,
                "title": "大公司头条：亚马逊正式宣布取消纽约新总部，不会另择新址；宁德时代将在德国建全球最大电池工厂，为宝马和戴姆勒供货；阿里巴巴入股 B 站，持股 8%",
                "content": "",
                "description": "我们每天早上为你摘取最重要的商业新闻，一切可能改变我们生活的公司都在其列。",
                "publish_time": 1550191906,
                "comment_count": 27,
                "praise_count": 88,
                "super_tag": "",
                "page_style": 0,
                "post_id": 64011,
                "datatype": "article",
                "category": {
                    "id": 18,
                    "title": "商业",
                    "image_black": "imgUrl",
                    "image_white": "imgUrl"
                },
                "column": {
                    "id": 1,
                    "name": "大公司头条",
                    "description": "",
                    "subscribe_status": false,
                    "icon": "imgUrl",
                    "image": "imgUrl",
                    "image_large": "imgUrl",
                    "content_provider": "好奇心日报",
                    "show_type": 1,
                    "genre": 1,
                    "subscriber_num": 1,
                    "post_count": 990,
                    "sort_time": "2019-02-15 08:51:46 +0800",
                    "column_tag": "special_columns_1",
                    "share": {
                        "url": "http://m.qdaily.com/mobile/special_columns/1.html",
                        "title": "大公司头条_好奇心日报",
                        "text": "大公司头条",
                        "image": "imgUrl"
                    }
                }
            },
            "list": [
                {
                    "title": "",
                    "description": "亚马逊正式宣布取消纽约新总部，不会另择新址",
                    "keywords": []
                },
                {
                    "title": "",
                    "description": "宁德时代将在德国建全球最大电池工厂，为宝马和戴姆勒供货",
                    "keywords": []
                },
                {
                    "title": "",
                    "description": "阿里巴巴入股 B 站，持股 8%",
                    "keywords": []
                }
            ],
            "headline_genre": 1
        },
        "banners_ad": [],
        "feeds_ad": [],
        "columns": []
    }
}
```

## 2.http://localhost:8080/ssm/getCategoryJson
- 获取首页滚动条信息

```java
//失败
{
    "meta": {
        "status": 200,
        "msg": "getCategoryJson failed"
    }
}
//成功
{
    "meta": {
        "status": 200,
        "msg": "success"
    },
    "response": {
        categories:[]
    }
}    
```

## 3.http://localhost:8080/ssm/getUpdatingsJson
- 获取动态列表基本信息

## 4.http://localhost:8080/ssm/getPapersJson/postId
- 根据id获得文章具体信息

```java
//失败
{
    "meta": {
        "status": 200,
        "msg": "getCategoryJson failed"
    }
}
//成功

{
    "meta": {
        "status": 200,
        "msg": "success"
    },
    "response": {
        "image": "imgUrl",
        "type": 1,
        "post": {
            "id": 61141,
            "genre": 1,
            "title": "春节期间看电影的人少了，但看 IMAX 的人增加了",
            "description": "票价变贵，让人更注重影片质量。",
            "publish_time": 1550011448,
            "comment_count": 84,
            "praise_count": 57,
            "super_tag": "",
            "page_style": 0,
            "post_id": 63914,
            "datatype": "article",
            "content": "<p nocleanhtml=\"true\">今年春节，中国电影市场发生了重要变化。</p><p>年初一票房 14.33 亿元，同比增长 12.13%，刷新了中国电影市场单日票房纪录；但此后 5 天，无论是票房还是观众人数都比去年春节明显下滑，最终，<a href=\"http://tech.163.com/19/0211/07/E7NGSUHP00097U7R.html\" rel=\"nofollow\">春节总票房为 57.84 亿元</a>，只比 2018 年春节档票房增长 0.2%。</p><p>在从年初二到年初六每天观众人数同比都下滑 10%左右的情况下，总票房能保住，靠的是更贵的票价，以及《流浪地球》口碑推动的一部分二刷、三刷需求。</p><p>其中，票价比普通银幕贵一截的 IMAX 影院，反而是逆势增长最强劲的。在今年春节档三部 IMAX 国产片《流浪地球》、《疯狂的外星人》和《飞驰人生》的推动下，IMAX 中国的 599 家影院，收获<a href=\"http://www.cs.com.cn/ssgs/gsxw/201902/t20190211_5922047.html\" rel=\"nofollow\">票房 2.17 亿元</a>，比 2018 年同期增长 40%，且观众人次比去年同期也增长了 16%。</p><p>虽然从结果上看，《流浪地球》是春节票房冠军，对总票房、IMAX 贡献都很明显，但过程其实比较有趣，2017、2018 年春节出现过的单日票房第一影片轮流坐的情况，在 2019 年的前几天也再次出现了。</p><p>在 2017 年春节，年初一的时候《西游伏妖篇》排片占比 34%；年初二《功夫瑜伽》反超《大闹天竺》；初四《功夫瑜伽》超过《西游伏妖篇》占票房头位；随后《乘风破浪》凭借口碑逆袭。到最后，《伏妖篇》、《功夫瑜伽》分别为 11.6 亿和 8.8 亿，《大闹天竺》5.8 亿，口碑最好的《乘风破浪》4.2 亿，差距其实不明显。</p><p>到了 2018 年春节，年初一是《捉妖记 2》单日 5 亿登顶；第二天则是《唐人街探案 2》和《红海行动》的上座率大幅反超《捉妖记 2》；随后《唐人街探案 2》跑赢，以 19.1 亿成为春节票房冠军，而《捉妖记 2》票房也超过 17 亿，差距也不大。</p><p>而今年的年初一<a href=\"http://www.qdaily.com/articles/61015.html\">票房</a>，《疯狂的外星人》为 3.80 亿元，《飞驰人生》3.03 亿元，《新喜剧之王》2.59 亿元；《流浪地球》只有1.84 亿元。但在收官的时候，《流浪地球》突破 20 亿元，周星驰的《新喜剧之王》和成龙的《神探蒲松龄》，口碑下滑非常快，分别只有 5.3 亿和 1.3 亿票房，明显低于预期；而此前通过营销大火的《小猪佩奇》，只有 1.1 亿票房。</p><p>这种每年春节票房轮流第一的情况，与市场上文化产品仍然比较稀缺，春节期间很多三四线城市的观众娱乐方式可能较少有关；且以往票补力度大，电影票价便宜，于是会出现短期内多次去电影院看不同片子的现象，使得影片票房排名出现快速波动。</p><p>但今年的情况不一样了，因为票价普遍贵了，年初一全国平均电影票价为 44.1 元，比 2018 年年初一的 37.3 元增长了 18%。</p><p>在这样的情况下，观众以往在过年的几天里，多次去电影院看不同片子的行为，很可能减少了，而更集中在口碑好的影片上。这可以解释，为什么今年春节观众人次减少，以及票房排名差距比以往明显加大的现象。</p><p>这种涨价后的观影行为，和前几年的补贴盛行下的影视行业发展思路截然相反。现在的局面，其实就是从观众端对电影供给端的改革的开始，只有建立在质量和口碑上的营销才能保证票房。</p><p class=\"\"><br></p><p>题图来源：《流浪地球》</p>",
            "tag": [
                {
                    "id": 1188,
                    "name": "票房"
                },
                {
                    "id": 38,
                    "name": "电影"
                },
                {
                    "id": 1415,
                    "name": "IMAX"
                }
            ],
            "related": [
                {
                    "image": "imgUrl",
                    "type": 1,
                    "post": {
                        "id": 61078,
                        "genre": 1,
                        "title": "「票房」春节档表现不好，《流浪地球》是唯一的票房亮点",
                        "description": "而它承载的意义也已经远超电影本身",
                        "publish_time": 1549838553,
                        "comment_count": 308,
                        "praise_count": 358,
                        "super_tag": "",
                        "page_style": 0,
                        "post_id": 63842,
                        "datatype": "article",
                        "category": {
                            "id": 3,
                            "title": "娱乐",
                            "image_black": "imgUrl",
                            "image_white": "imgUrl"
                        },
                        "column": {
                            "id": 16,
                            "name": "票房",
                            "description": "你为什么看了这些电影，背后有什么商业秘密",
                            "subscribe_status": true,
                            "icon": "imgUrl",
                            "image": "imgUrl",
                            "image_large": "imgUrl",
                            "content_provider": "好奇心日报",
                            "show_type": 1,
                            "genre": 1,
                            "subscriber_num": 70565,
                            "post_count": 192,
                            "sort_time": "2019-02-11 06:42:33 +0800",
                            "column_tag": "special_columns_16",
                            "share": {
                                "url": "http://m.qdaily.com/mobile/special_columns/16.html",
                                "title": "票房_好奇心日报",
                                "text": "你为什么看了这些电影，背后有什么商业秘密",
                                "image": "imgUrl"
                            }
                        }
                    }
                },
                {
                    "image": "imgUrl",
                    "type": 1,
                    "post": {
                        "id": 61015,
                        "genre": 1,
                        "title": "「票房」大年初一票房还在涨，但看电影的人变少了",
                        "description": "从 3263 万张出票量回落到 3140 万张，春节档似乎也越来越不是旱涝保收的季节了。",
                        "publish_time": 1549415017,
                        "comment_count": 169,
                        "praise_count": 270,
                        "super_tag": "",
                        "page_style": 0,
                        "post_id": 63779,
                        "datatype": "article",
                        "category": {
                            "id": 3,
                            "title": "娱乐",
                            "image_black": "imgUrl",
                            "image_white": "imgUrl"
                        },
                        "column": {
                            "id": 16,
                            "name": "票房",
                            "description": "你为什么看了这些电影，背后有什么商业秘密",
                            "subscribe_status": true,
                            "icon": "imgUrl",
                            "image": "imgUrl",
                            "image_large": "imgUrl",
                            "content_provider": "好奇心日报",
                            "show_type": 1,
                            "genre": 1,
                            "subscriber_num": 70565,
                            "post_count": 192,
                            "sort_time": "2019-02-11 06:42:33 +0800",
                            "column_tag": "special_columns_16",
                            "share": {
                                "url": "http://m.qdaily.com/mobile/special_columns/16.html",
                                "title": "票房_好奇心日报",
                                "text": "你为什么看了这些电影，背后有什么商业秘密",
                                "image": "imgUrl"
                            }
                        }
                    }
                }
            ],
            "inner_image": "imgUrl",
            "category": {
                "id": 18,
                "title": "商业",
                "image_black": "imgUrl",
                "image_white": "imgUrl"
            }
        },
        "author": {
            "id": 1318050,
            "description": "",
            "avatar": "imgUrl",
            "name": "姚书恒",
            "background_image": "http://app3.qdaily.com/default_images/missing_loading.jpg"
        }
    }
}
```

## 5.http://localhost:8080/ssm/getUpdatingsJson/postId
- 获取根据id获取文章信息
