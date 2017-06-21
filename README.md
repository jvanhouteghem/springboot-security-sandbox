# springboot-security-sandbox

0. Initialize

- New sping boot project > choose web (web) and security (core)
- Run, go to localhost:8080. Login is user and credential is display on console output (for example cada4af1-9a3f-42df-b822-372c6b6835c7).
- When logged in you will see a Whitelabel Error Page.

1. Create a custom (hardcoded) user

- Open application.properties and add the folowing lines : 
security.user.name=jo
security.user.password=pass
- Restart and try new credential

2. Create a new security configuration

```
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

}
```

3. Add new controller

```
@RestController
@RequestMapping("/post")
public class CustomController {

	@RequestMapping("/list")
	public String list(){
		return "list posts...";
	}
	
}
```

4. Add custom admin and user
```
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("admin")
				.password("admin")
				.roles("ADMIN")
			.and()
				.withUser("user")
				.password("user")
				.roles("USER");
	}

}
```

5. Override configure
```
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers("/post/list").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.and()
			.logout();
	}
	
Log in with user/user and load http://localhost:8080/admin : access is denied
```