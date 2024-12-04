document.querySelectorAll('#project-dates').forEach(item => {
    const startDate = item.dataset.start.substring(0, 10);
    const endDate = item.dataset.end.substring(0, 10);
    item.textContent = `${startDate} ~ ${endDate}`;
});

