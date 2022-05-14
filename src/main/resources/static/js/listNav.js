const nav = document.querySelectorAll('.nav>li');
const subNav = document.querySelectorAll('.nav .sub-nav');
const a = document.querySelectorAll('.nav a');


if (nav) {
	for (item of nav) {
		const subNav = item.lastElementChild;
		item.addEventListener('click', () => {
			subNav.classList.toggle('JS-sub-nav-fade-out');
		})
	}
}

if (subNav) {
	for (item of subNav) {
		item.addEventListener('click', (e) => {
			e.stopPropagation();
		})
	}
}

if (a) {
	for (item of a) {
		const li = item.lastElementChild;
		item.addEventListener('click', () => {
			const aActive = document.querySelector('.JS-sub-nav-a-active');
			if (aActive) {
				aActive.classList.remove('JS-sub-nav-a-active');
			}
			li.classList.add('JS-sub-nav-a-active');
		})
	}
}
