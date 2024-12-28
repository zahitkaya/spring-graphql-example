# GraphQL Nedir? Neden Kullanmalıyız?

GraphQL, Facebook tarafından geliştirilmiş bir **query language** (sorgu dili) ve sunucu tarafında çalışan bir **runtime**dır. GraphQL’in temel amacı, istemci (frontend) ile sunucu (backend) arasındaki veri iletişimini daha verimli ve esnek hale getirmektir.

## GraphQL’in Avantajları

### 1. **Daha Hassas Veri Alımı (Overfetching ve Underfetching’in Çözümü)**
- Geleneksel REST API'lerde, gereğinden fazla veri almak (**overfetching**) veya gerekli veriye ulaşamamak (**underfetching**) sıkça karşılaşılan bir problemdir.
- GraphQL’de istemci sadece ihtiyaç duyduğu veriyi talep eder. Örneğin:

```graphql
query {
  user {
    id
    name
    email
  }
}
```
Bu sorgu yalnızca `id`, `name` ve `email` alanlarını döndürür, fazlasını değil.

---

### 2. **Tek Bir Uç Nokta (Endpoint)**
- REST ile genellikle her veri türü için farklı bir endpoint tanımlanır (örnek: `/users`, `/products`, vb.).
- GraphQL, **tek bir endpoint** üzerinden çalışır. İhtiyaç duyduğumuz her tür veriye bu endpoint ile ulaşabiliriz.

```bash
POST /graphql
Content-Type: application/json
```

---

### 3. **Tip Güvenliği ve Şema (Schema)**
- GraphQL, istemcinin hangi veri türlerini isteyebileceğini bir **şema (schema)** ile tanımlar.
- Şema, API’ye dair net bir dökümantasyon sunar ve daha kolay hata ayıklama imkanı sağlar.

---

### 4. **Gerçek Zamanlı Veri (Subscriptions)**
- GraphQL ile gerçek zamanlı veri iletişimi kurmak oldukça kolaydır. `Subscription` özelliği sayesinde istemci, sunucuda gerçekleşen belirli olayları dinleyebilir.

---

### 5. **Otomatik Dökümantasyon**
- Şema temelli yapısı sayesinde, araçlar (ör: GraphiQL veya Apollo Explorer) otomatik dökümantasyon imkanı sunar. Bu sayede ekibin API’yi anlama süreci hızlanır.

---

## GraphQL’in Dezavantajları

### 1. **Performans Problemleri**
- GraphQL sorguları esnek olduğu için karmaşık sorgular (nested queries) kolayca oluşturulabilir. Bu durum, özellikle büyük ve karmaşık şemalarda performans sorunlarına neden olabilir.
- REST API gibi sunucuya tam olarak optimize edilmiş değildir.

---

### 2. **Önyükleme Süreci (Setup)**
- İlk kurulum, REST API’ye göre daha zahmetlidir. Şemanın dikkatlice tanımlanması ve optimizasyon yapılması gerekir.

---

### 3. **N+1 Sorgu Problemi**
- Özellikle ilişkisel veri tabanlarında, GraphQL ile istemci birden fazla nested sorgu oluşturduğunda, N+1 sorgu problemi nedeniyle performans sorunları yaşanabilir.

> Örnek: Ürünleri sorgularken, her ürünle ilişkili kategoriyi ayrı ayrı sorgulama.

---

### 4. **Önbellekleme (Caching)**
- REST API'de önbellekleme (örneğin: HTTP cache) standartlaşıp kolayca uygulanabilirken, GraphQL'de sorgu yapıları çok dinamik olduğu için bu daha zordur. Ek araçlar (ör: Apollo Cache) gerekebilir.

---

### 5. **Öğrenme Eğrisi**
- REST API'ye aşina olan bir ekip için GraphQL öğrenme süreci zaman alabilir.

---

## GraphQL’i Ne Zaman Kullanmalıyız?

- Mevcut veya yeni bir API’nin esnek veri sorgulamalarına ihtiyaç duyacağı bir durum varsa.
- REST API ile **overfetching** veya **underfetching** sorunları yaşanıyorsa.
- Gerçek zamanlı veri akışı (**real-time updates**) gerektiren bir uygulama geliştiriyorsanız.
- Frontend’in farklı ekranlarında farklı veri yapılarına ihtiyaç duyuluyorsa.

---

## GraphQL’i Ne Zaman Kullanmamalıyız?

- API’miz basit ve sabit bir yapıya sahipse.
- Performans hassasiyeti yüksek ve büyük veri sorguları olan bir sistemde.
- REST’in sunduğu önbellekleme gibi özelliklere ihtiyaç duyuluyorsa.

---

## Örnek GraphQL Sorgusu ve Şema

**GraphQL Query:**

```graphql
query {
  user(id: 1) {
    id
    name
    email
    posts {
      title
      comments {
        text
      }
    }
  }
}
```

**GraphQL Şema:**

```graphql
type User {
  id: ID!
  name: String!
  email: String!
  posts: [Post]
}

type Post {
  id: ID!
  title: String!
  comments: [Comment]
}

type Comment {
  id: ID!
  text: String!
}
```

Bu sorgu, kullanıcı bilgilerini, kullanıcının gönderilerini ve bu gönderilere yapılan yorumları tek bir istekte alabilir.

---

#### References
https://graphql.org/learn/
https://www.linkedin.com/learning/spring-with-graphql