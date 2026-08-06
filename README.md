# Practice Project — Swagger Khud Setup Karo

Ye ek basic, working Spring Boot project hai (`/api/hello` aur `/api/greet/{name}` endpoints ke saath). **Swagger jaanbujh kar add nahi kiya gaya** — isse aap khud practice kar sako.

## Pehle Verify Karo Project Chal Raha Hai

```bash
cd practice-project
./mvnw spring-boot:run
```

Naye terminal mein:
```bash
curl http://localhost:8080/api/hello
curl http://localhost:8080/api/greet/Prince
```

Dono response dena chahiye. Agar chal raha hai, tabhi aage badho.

---

## Aapka Task — Checklist

Is project mein 3 jagah `TODO` comments chhode hain — unhi ko dhundo aur khud complete karo:

- [ ] **`pom.xml`** — Swagger/OpenAPI dependency add karo (`TODO` comment dekho, hint diya hua hai)
- [ ] **`application.properties`** — Swagger enable karne ki properties add karo (`TODO` comment dekho)
- [ ] Project ko rebuild karo aur restart karo
- [ ] Swagger UI browser mein khol ke verify karo

## Hints (Agar Atak Jao)

<details>
<summary>Hint 1 — Dependency kaunsi chahiye?</summary>

Library ka naam **Springdoc OpenAPI** hai. Maven Central par search karo:
`springdoc-openapi-starter-webmvc-ui`

</details>

<details>
<summary>Hint 2 — Dependency kaha add karni hai?</summary>

`pom.xml` mein `<dependencies>` tag ke andar, jaha `TODO` comment likha hai.

</details>

<details>
<summary>Hint 3 — Swagger UI ka URL kya hota hai?</summary>

Rebuild + restart karne ke baad:
```
http://localhost:8080/swagger-ui/index.html
```

</details>

<details>
<summary>Hint 4 — Rebuild kaise karu?</summary>

```bash
./mvnw clean package
./mvnw spring-boot:run
```

</details>

---

## Bonus Challenge (Optional, Thoda Advanced)

Jab basic Swagger setup ho jaye, ye bhi try karo:

1. Ek naya controller banao (jaise `UserController.java`) with GET/POST endpoints
2. Rebuild karo — check karo naya controller Swagger mein apne aap dikhta hai ya nahi
3. `application.properties` mein Swagger ko `false` karke dekho — verify karo Swagger UI 404 deta hai

---

## Stuck Ho Gaye?

Jo bhi error aaye (Maven build fail, Swagger 404, etc.) — mujhe exact error paste kar dena, main debug karne mein help karunga. Lekin pehle khud try karna — yahi seekhne ka sabse acha tarika hai.
