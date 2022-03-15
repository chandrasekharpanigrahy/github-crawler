package com.societegenerale.githubcrawler.config


import com.societegenerale.githubcrawler.GitHubCrawlerProperties
import com.societegenerale.githubcrawler.remote.RemoteGitHub
import com.societegenerale.githubcrawler.remote.RemoteGitLabImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "github-crawler.githubConfig", name = ["type"], havingValue = "GITLAB")
open class GitLabConfiguration {

    @Bean
    open fun remoteGitLab(gitHubCrawlerProperties: GitHubCrawlerProperties): RemoteGitHub {

        return RemoteGitLabImpl(gitHubCrawlerProperties.githubConfig.apiUrl,gitHubCrawlerProperties.githubConfig.oauthToken)
    }

}
