package utility;

import model.Blog;

public class CheckBlogPost extends OffensiveWordsChecker implements OffensiveWordsInterface {

	String[] str = { "a$$", "a$$hole", "a_s_s", "ahole", "alabama hot pocket", "alaskan pipeline", "anal",
			"anal impaler", "anal leakage", "analprobe", "anilingus", "anus", "apeshit", "ar5e", "areola", "areole",
			"arian", "arrse", "arse", "arsehole", "aryan", "ass", "ass fuck", "f u c k", "f u c k e r", "f.u.c.k",
			"f_u_c_k", "fudge packer", "fudgepacker", "fudge-packer", "fuk", "fuker", "fukker", "fukkers", "fukkin",
			"fuks", "fukwhit", "fukwit", "fuq", "futanari", "fux", "fux0r", "fvck", "fxck", "gae", "gai", "gang bang",
			"gangbang", "gang-bang", "gang-bang", "gangbanged", "gangbangs", "ganja", "gash", "gassy ass", "gassy ass",
			"gay", "gay sex", "gayass", "gaybob", "gaydo", "gayfuck", "gayfuckist", "gaylord", "gays", "gaysex",
			"gaytard", "gaywad", "gender bender", "genitals", "gey", "gfy", "ghay", "ghey", "giant cock", "gigolo",
			"ginger", "gippo", "girl on", "girl on top", "girls gone wild", "git", "glans", "goatcx", "goatse",
			"god damn", "godamn", "godamnit", "goddam", "god-dam", "goddammit", "goddamn", "goddamned", "god-damned",
			"goddamnit", "godsdamn", "gokkun", "golden shower", "goldenshower", "golliwog", "gonad", "gonads",
			"goo girl", "gooch", "goodpoop", "gook", "gooks", "goregasm", "gringo", "grope", "group sex", "gspot",
			"g-spot", "gtfo", "guido", "guro", "h0m0", "h0mo", "ham flap", "ham flap", "hand job", "handjob",
			"hard core", "hard on", "hardcore", "hardcores" };

	@Override
	public boolean checkBlogTitle(Blog blog) {
		String blogTitle = blog.getBlogTitle();
		String[] arr = blogTitle.toLowerCase().split(" ");
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < str.length; j++) {
				if (str[j].equals(arr[i])) {
					flag = true;
					break;
				}
			}
		}

		return flag;
	}

	@Override
	public boolean checkBlogDescription(Blog blog) {
		String blogDesc = blog.getBlogDescription();
		String[] arr = blogDesc.split(" ");
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < str.length; j++) {
				if (str[j].equals(arr[i])) {
					flag = true;
					break;
				}
			}
		}

		return flag;
	}

	@Override
	public boolean checkBlog(Blog blog) {
		boolean flag = true;
		if (checkBlogTitle(blog) || checkBlogDescription(blog)) {
			flag = false;
		}
		return flag;
	}

}